package com.fpcs.invt.mgmt.sys.service.impl;

import java.lang.reflect.Field;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.dao.RegistrationDAO;
import com.fpcs.invt.mgmt.sys.dao.UserLoginDAO;
import com.fpcs.invt.mgmt.sys.domain.shop_data.ShopDetails;
import com.fpcs.invt.mgmt.sys.domain.user_data.UserLogin;
import com.fpcs.invt.mgmt.sys.enums.MANDAT_FIELDS_VO;
import com.fpcs.invt.mgmt.sys.service.RegistrationService;
import com.fpcs.invt.mgmt.sys.utils.DataMapper;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.MessagesReader;
import com.fpcs.invt.mgmt.sys.utils.ObjectFactory;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.validation.MandatoryInputValidator;
import com.fpcs.invt.mgmt.sys.vo.ShopRegistrationVO;
import com.fpcs.invt.mgmt.sys.vo.UserRegistrationVO;

@Service
@SuppressWarnings("unchecked")
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	private ObjectFactory objectFactory = ObjectFactory.getObjectFactory();
	
	@Autowired
	private DataMapper dataMapper;
	
	@Autowired
	private RegistrationDAO registrationDAO; 
	
	@Autowired
	private UserLoginDAO userLoginDAO;
	
	@Autowired
	private MandatoryInputValidator mandatoryInputValidator;
	
	@Override
	@Transactional
	public ResponseMessage saveShopDetails(ShopRegistrationVO shopRegistrationVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap) {
		ResponseMessage responseMessage = objectFactory.getResponseMessage();
		Map<String,Object> message = objectFactory.getMap();
		Long shopId = null;
		try {
			Field[] fields = shopRegistrationVO.getClass().getDeclaredFields();
			if(mandatoryInputValidator.validateAllMandatoryFields(MANDAT_FIELDS_VO.SHOP_REGISTRATION_VO.getMandatFields(), fields , shopRegistrationVO)) {
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
			} else {
				message.put(CommonConstants.ERROR, 
						InvtMgmtUtil.join(MessagesReader.getMessage("GenericMessage.AllMandatFieldsNotProvided")));
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

	@Override
	@Transactional
	public ResponseMessage saveUserDetails(UserRegistrationVO userRegistrationVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap) {
		ResponseMessage responseMessage = objectFactory.getResponseMessage();
		Map<String,Object> message = objectFactory.getMap();
		boolean isSaved = false;
		try {
			Field[] fields = userRegistrationVO.getClass().getDeclaredFields();
			if(mandatoryInputValidator.validateAllMandatoryFields(MANDAT_FIELDS_VO.SHOP_REGISTRATION_VO.getMandatFields(), fields , userRegistrationVO)) {
				UserLogin userLogin = dataMapper.mapUserLoginDetail(userRegistrationVO);
				userLogin.setUserName(this.generateUserName());
				userLogin.setPassword(InvtMgmtUtil.generatePassword());
				isSaved = registrationDAO.saveUserDetails(userLogin);
				if(isSaved) {
					message.put(CommonConstants.SUCCESS, 
							InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.UserDetailsSaved") , 
									CommonConstants.SPACE , userLogin.getUserName()));
				} else {
					message.put(CommonConstants.ERROR, 
							InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.UserDetailsNotSaved")));
				}
			} else {
				message.put(CommonConstants.ERROR, 
						InvtMgmtUtil.join(MessagesReader.getMessage("GenericMessage.AllMandatFieldsNotProvided")));
			}
		} catch(InvtMgmtSysException e) {
			logger.error("excpetion occurred while saving shop details" , e);
			message.put(CommonConstants.ERROR, 
					InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ExceptionUserDetail")));
		} catch(Exception e) {
			logger.error("excpetion occurred while saving shop details" , e);
			message.put(CommonConstants.ERROR, 
					InvtMgmtUtil.join(MessagesReader.getMessage("RegistrationServiceImpl.ExceptionUserDetail")));
		}
		responseMessage.setMessage(message);
		return responseMessage;
	}

	private String generateUserName() {
		String username = InvtMgmtUtil.generateUserName();
		UserLogin userLogin = userLoginDAO.getUserLogin(username);
		if(null != userLogin) {
			this.generateUserName();
		}
		return username;
	}
	
}
