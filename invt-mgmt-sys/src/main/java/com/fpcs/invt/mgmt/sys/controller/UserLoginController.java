package com.fpcs.invt.mgmt.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpcs.invt.mgmt.sys.constants.JspConstants;
import com.fpcs.invt.mgmt.sys.security.SessionUtil;
import com.fpcs.invt.mgmt.sys.service.UserLoginService;

import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.MENUES;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.USER_ROLE;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.BASE_URL;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.INDEX;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.LOGIN;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.LOGOUT;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.ERROR;
import static com.fpcs.invt.mgmt.sys.constants.ControllerConstants.ERROR_PAGE;;

@Controller
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService; 
	
	@RequestMapping(value = BASE_URL, method=RequestMethod.GET)
	public String login() {
		return JspConstants.LOGIN;
	}
	
	@RequestMapping(value = INDEX, method = RequestMethod.GET)
	public String defaultPage(HttpServletRequest request , Map<String,String> map) {
		userLoginService.setUserDetails(request);
		map.put(USER_ROLE, SessionUtil.getUserContext(request).getUserDetail().getRole());
		map.put(MENUES, userLoginService.getAllowedMenues(request));
	  return JspConstants.INDEX;
	}

	@RequestMapping(value = LOGIN, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = ERROR, required = false) String error,
		@RequestParam(value = LOGOUT, required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject(ERROR, "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName(JspConstants.LOGIN);

	  return model;

	}

	//for 403 access denied page
	@RequestMapping(value = ERROR_PAGE, method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName(JspConstants.ERROR_PAGE);
	  return model;

	}
	
}
