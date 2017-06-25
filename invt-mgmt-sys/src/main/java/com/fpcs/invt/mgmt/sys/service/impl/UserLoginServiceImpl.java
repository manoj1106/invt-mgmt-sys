package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.dao.UserLoginDAO;
import com.fpcs.invt.mgmt.sys.domain.UserLogin;
import com.fpcs.invt.mgmt.sys.parser.MenuBuilder;
import com.fpcs.invt.mgmt.sys.security.SessionUtil;
import com.fpcs.invt.mgmt.sys.security.UserContext;
import com.fpcs.invt.mgmt.sys.service.MenuItemAccessService;
import com.fpcs.invt.mgmt.sys.service.UserLoginService;
import com.fpcs.invt.mgmt.sys.utils.DataMapper;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.MenuItemAccessVO;


@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	
	@Autowired
	private UserLoginDAO userLoginDAO;
	
	@Autowired
	private DataMapper dataMapper;
	
	@Autowired
	private MenuItemAccessService menuItemAccessService;
	
	@Autowired
	private MenuBuilder menuBuilder;
	
	@Override
	public String getAllowedMenues(HttpServletRequest request) {
		UserContext context = SessionUtil.getUserContext(request);
		MenuItemAccessVO menuItemAccessVO = new MenuItemAccessVO();
		menuItemAccessVO.setRole(context.getUserDetail().getRole());
		menuItemAccessVO.setShopId(context.getUserDetail().getShopId());
		String menues = CommonConstants.EMPTY_STRING;
		Set<String> allowedMenues = menuItemAccessService.getAllowedMenues(
				menuItemAccessVO, new ErrorHandler(), new HashMap<>());
		if(InvtMgmtUtil.isNotNull(allowedMenues) && !allowedMenues.isEmpty()) {
			menues = menuBuilder.getMenues(allowedMenues);
		}
		return menues;
	}
	
	@Override
	@Transactional
	public void setUserDetails(HttpServletRequest request) {
		logger.debug("checking the user login details for username ");
		UserLogin userLogin = null;
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails)auth.getPrincipal();
			userLogin = userLoginDAO.getUserLogin(userDetails.getUsername());
			this.createUserContext(userLogin, request);
		} catch(Exception e) {
			logger.error("error occurred while getting user details from the database...");
		}
	}
	
	private void createUserContext(UserLogin userLogin , HttpServletRequest request) {
		UserContext.UserDetail userDetail = dataMapper.mapUserDetail(userLogin);
		if(null != userLogin && null != userLogin.getShopDetails()) {
			userDetail.setShopId(userLogin.getShopDetails().getShopId());
		} else {
			userDetail.setShopId(null);
		}
		if(null != userLogin && null != userLogin.getRoles()) {
			userDetail.setRole(userLogin.getRoles().getRole());
		}
		
		SessionUtil.setUserContext(userDetail, request);
	}

}
