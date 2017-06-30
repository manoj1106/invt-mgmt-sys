package com.fpcs.invt.mgmt.sys.service;

import java.util.Map;

import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.ShopRegistrationVO;
import com.fpcs.invt.mgmt.sys.vo.UserRegistrationVO;

public interface RegistrationService {

	public ResponseMessage saveShopDetails(ShopRegistrationVO shopRegistrationVO , ErrorHandler errorHandler ,
			Map<String,Object> contextMap);

	public ResponseMessage saveUserDetails(UserRegistrationVO userRegistrationVO, ErrorHandler errorHandler,
			Map<String, Object> contextMap);
	
}
