package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.dao.RegistrationDAO;
import com.fpcs.invt.mgmt.sys.domain.shop_data.ShopDetails;
import com.fpcs.invt.mgmt.sys.service.RegistrationService;
import com.fpcs.invt.mgmt.sys.utils.DataMapper;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.MessagesReader;
import com.fpcs.invt.mgmt.sys.utils.ObjectFactory;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.vo.ShopRegistrationVO;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	private ObjectFactory objectFactory = ObjectFactory.getObjectFactory();
	
	@Autowired
	private DataMapper dataMapper;
	
	@Autowired
	private RegistrationDAO registrationDAO; 
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseMessage saveShopDetails(ShopRegistrationVO shopRegistrationVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap) {
		ResponseMessage responseMessage = objectFactory.getResponseMessage();
		Map<String,Object> message = objectFactory.getMap();
		Long shopId = null;
		try {
			ShopDetails shopDetails = dataMapper.mapShopDetail(shopRegistrationVO);
			shopId = registrationDAO.saveShopDetails(shopDetails);
			if(null != shopId && shopId > 0) {
				message.put(CommonConstants.SUCCESS, 
						InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ShopDetailsSaved") , 
								CommonConstants.SPACE , shopId));
			} else {
				message.put(CommonConstants.ERROR, 
						InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ShopDetailsNotSaved")));
			}
		} catch(InvtMgmtSysException e) {
			logger.error("excpetion occurred while saving shop details" , e);
			message.put(CommonConstants.ERROR, 
					InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ExceptionShopDetail")));
		} catch(Exception e) {
			logger.error("excpetion occurred while saving shop details" , e);
			message.put(CommonConstants.ERROR, 
					InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ExceptionShopDetail")));
		}
		responseMessage.setMessage(message);
		return responseMessage;
	}

	
	
}
