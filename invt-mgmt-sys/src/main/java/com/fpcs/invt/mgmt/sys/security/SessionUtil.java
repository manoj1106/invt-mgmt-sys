package com.fpcs.invt.mgmt.sys.security;


import javax.servlet.http.HttpServletRequest;

import static com.fpcs.invt.mgmt.sys.constants.CommonConstants.USER_CONTEXT;

public class SessionUtil {

	private SessionUtil() {
		
	}
	
	public static void setUserContext(UserContext.UserDetail userDetail,HttpServletRequest request) {
		UserContext userContext = new UserContext();
		userContext.setUserDetail(userDetail);
		request.getSession().setAttribute(USER_CONTEXT, userContext);
	}
	
	public static UserContext getUserContext(HttpServletRequest request) {
		return (UserContext)request.getSession().getAttribute(USER_CONTEXT);
	}
	
}
