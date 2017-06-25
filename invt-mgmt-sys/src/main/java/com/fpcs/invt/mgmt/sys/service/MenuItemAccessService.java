package com.fpcs.invt.mgmt.sys.service;

import java.util.Map;
import java.util.Set;

import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.MenuItemAccessVO;

/**
 * @author Manoj Patel
 *
 */
public interface MenuItemAccessService {

	ResponseMessage saveMenuItemAccess(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap);
	
	Set<String> getAllowedMenues(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap);
	
	Set<String> getRoles();
	
	String getAllMenues();
	
	ResponseMessage getMenuItems(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap);
	
}
