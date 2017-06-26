package com.fpcs.invt.mgmt.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpcs.invt.mgmt.sys.constants.ControllerConstants;
import com.fpcs.invt.mgmt.sys.constants.JspConstants;
import com.fpcs.invt.mgmt.sys.service.CacheService;
import com.fpcs.invt.mgmt.sys.service.RegistrationService;
import com.fpcs.invt.mgmt.sys.utils.ObjectFactory;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.ShopRegistrationVO;

@Controller
@RequestMapping(value=ControllerConstants.REGISTRATION_BASE_URL)
public class RegistrationController {
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private RegistrationService registrationService;

	private ObjectFactory objectFactory = ObjectFactory.getObjectFactory();
	
	@RequestMapping(value=ControllerConstants.USER_REGISTRATION , method=RequestMethod.GET)
	public String getUserRegistrationPage(HttpServletRequest request , Map<String,Object> map) {
		map.put(ControllerConstants.COUNTRIES, cacheService.getCountries());
		return JspConstants.USER_REGISTRATION;
	}
	
	@RequestMapping(value=ControllerConstants.SHOP_REGISTRATION , method=RequestMethod.GET)
	public String getShopRegistrationPage(HttpServletRequest request , Map<String,Object> map) {
		map.put(ControllerConstants.COUNTRIES, cacheService.getCountries());
		return JspConstants.SHOP_REGISTRATION;
	}
	
	@ResponseBody
	@RequestMapping(value = ControllerConstants.SAVE_SHOP_DETAILS , method = RequestMethod.POST)
	public ResponseMessage saveShopDetails(@RequestBody ShopRegistrationVO shopRegistrationVO) {
		ErrorHandler errorHandler = objectFactory.getErrorHandler();
		Map<String,Object> contextMap = objectFactory.getMap();
		return registrationService.saveShopDetails(shopRegistrationVO, errorHandler, contextMap);
	}
	
}
