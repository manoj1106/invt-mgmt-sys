package com.fpcs.invt.mgmt.sys.service;

import javax.servlet.http.HttpServletRequest;

public interface UserLoginService {

	public String getAllowedMenues(HttpServletRequest request);
	
	public void setUserDetails(HttpServletRequest request);
}
