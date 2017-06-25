package com.fpcs.invt.mgmt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fpcs.invt.mgmt.sys.constants.ControllerConstants;
import com.fpcs.invt.mgmt.sys.constants.JspConstants;

@Controller
@RequestMapping(value=ControllerConstants.REGISTRATION_BASE_URL)
public class RegistrationController {

	@RequestMapping(value=ControllerConstants.USER_REGISTRATION , method=RequestMethod.GET)
	public String getUserRegistrationPage() {
		return JspConstants.USER_REGISTRATION;
	}
	
	@RequestMapping(value=ControllerConstants.SHOP_REGISTRATION , method=RequestMethod.GET)
	public String getShopRegistrationPage() {
		return JspConstants.SHOP_REGISTRATION;
	}
	
}
