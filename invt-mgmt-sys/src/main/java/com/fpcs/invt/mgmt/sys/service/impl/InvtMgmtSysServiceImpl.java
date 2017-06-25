package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.service.CacheService;
import com.fpcs.invt.mgmt.sys.service.InvtMgmtSysService;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.ObjectFactory;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.InvtMgmtSysVO;

@Service
public class InvtMgmtSysServiceImpl implements InvtMgmtSysService {

	private static final Logger logger = LoggerFactory.getLogger(InvtMgmtSysServiceImpl.class);
	
	private ObjectFactory objectFactory = ObjectFactory.getObjectFactory();
	
	@Autowired
	private CacheService cacheService;
	
	@Override
	public ResponseMessage getStatesByCountry(InvtMgmtSysVO invtMgmtSysVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap) {
		logger.debug("getting states by country for country {} " , invtMgmtSysVO.getCountry());
		ResponseMessage responseMessage = new ResponseMessage();
		Map<String , Object> message = objectFactory.getMessageMap();
		Map<String , Object> dataMap = objectFactory.getMessageMap();
		try {
			if(InvtMgmtUtil.isNotBlank(invtMgmtSysVO.getCountry())) {
				 dataMap.put(CommonConstants.STATES, cacheService.getStates(invtMgmtSysVO.getCountry()));
				 responseMessage.setDataMap(dataMap);
			} else {
				message.put(CommonConstants.ERROR, "Please provide country name");
				responseMessage.setMessages(message);
			}
		} catch(Exception e) {
			logger.error("exception occurred while getting states by country" , e);
			message.put(CommonConstants.ERROR, "exception occurred while getting states by country");
			responseMessage.setMessages(message);
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage getCitiesByStates(InvtMgmtSysVO invtMgmtSysVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap) {
		ResponseMessage responseMessage = new ResponseMessage();
		logger.debug("getting cities by state for state {} " , invtMgmtSysVO.getState());
		Map<String , Object> message = objectFactory.getMessageMap();
		Map<String , Object> dataMap = objectFactory.getMessageMap();
		try {
			if(InvtMgmtUtil.isNotBlank(invtMgmtSysVO.getState())) {
				 dataMap.put(CommonConstants.CITIES, cacheService.getCities(invtMgmtSysVO.getState()));
				 responseMessage.setDataMap(dataMap);
			} else {
				message.put(CommonConstants.ERROR, "Please provide state");
				responseMessage.setMessages(message);
			}
		} catch(Exception e) {
			logger.error("exception occurred while getting cities by states" , e);
			message.put(CommonConstants.ERROR, "exception occurred while getting cities by states");
			responseMessage.setMessages(message);
		}
		return responseMessage;
	}

}
