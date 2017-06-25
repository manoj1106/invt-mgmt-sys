package com.fpcs.invt.mgmt.sys.utils;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fpcs.invt.mgmt.sys.domain.UserLogin;
import com.fpcs.invt.mgmt.sys.security.UserContext;

@Component
public class DataMapper {

	@Autowired
	private Mapper mapper;
	
	public UserContext.UserDetail mapUserDetail(UserLogin userLogin) {
		return (UserContext.UserDetail)mapper.map(userLogin, UserContext.UserDetail.class);
	}
	
}
