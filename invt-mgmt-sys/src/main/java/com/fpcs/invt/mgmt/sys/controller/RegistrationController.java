package com.fpcs.invt.mgmt.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fpcs.invt.mgmt.sys.constants.ControllerConstants;
import com.fpcs.invt.mgmt.sys.constants.JspConstants;
import com.fpcs.invt.mgmt.sys.service.CacheService;

@Controller
@RequestMapping(value=ControllerConstants.REGISTRATION_BASE_URL)
public class RegistrationController {
	
	@Autowired
	private CacheService cacheService;

	@RequestMapping(value=ControllerConstants.USER_REGISTRATION , method=RequestMethod.GET)
	public String getUserRegistrationPage(HttpServletRequest request , Map<String,Object> map) {
		return JspConstants.USER_REGISTRATION;
	}
	
	@RequestMapping(value=ControllerConstants.SHOP_REGISTRATION , method=RequestMethod.GET)
	public String getShopRegistrationPage(HttpServletRequest request , Map<String,Object> map) {
		map.put(ControllerConstants.COUNTRIES, cacheService.getCountries());
		return JspConstants.SHOP_REGISTRATION;
	}
	
}
