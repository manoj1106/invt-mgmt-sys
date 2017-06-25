/**
 * 
 */
package com.fpcs.invt.mgmt.sys.controller;

import java.util.HashMap;
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
import com.fpcs.invt.mgmt.sys.security.SessionUtil;
import com.fpcs.invt.mgmt.sys.security.UserContext;
import com.fpcs.invt.mgmt.sys.service.MenuItemAccessService;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.vo.MenuItemAccessVO;

/**
 * @author Manoj Patel
 *
 */
@Controller
@RequestMapping(value=ControllerConstants.MENU_ITEM_ACCESS_BASE_URL)
public class MenuItemAccessController {
	

	@Autowired
	private MenuItemAccessService menuItemAccessService;
	
	@RequestMapping(value = ControllerConstants.MENU_ITEM_ACCESS , method = RequestMethod.GET)
	public String getMessagesPage(Map<String,Object> map) {
		map.put(ControllerConstants.ROLES, menuItemAccessService.getRoles());
		return JspConstants.MENU_ITEM_ACCESS;
	}
	
	@RequestMapping(value = ControllerConstants.GET_MENU_ITEMS , method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage getMenuItems(MenuItemAccessVO menuItemAccessVO,HttpServletRequest request) {
		ErrorHandler errorHandler = new ErrorHandler();
		Map<String,Object> contextMap = new HashMap<>();
		UserContext userContext = SessionUtil.getUserContext(request); 
		menuItemAccessVO.setRole(userContext.getUserDetail().getRole());
		menuItemAccessVO.setShopId(userContext.getUserDetail().getShopId());
		return menuItemAccessService.getMenuItems(menuItemAccessVO, errorHandler, contextMap);
	}
	
	@RequestMapping(value = ControllerConstants.SAVE_MENU_ITEM_ACCESS , method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage saveMenuItemAccess(@RequestBody MenuItemAccessVO menuItemAccessVO) {
		ErrorHandler errorHandler = new ErrorHandler();
		Map<String,Object> contextMap = new HashMap<>();
		return menuItemAccessService.saveMenuItemAccess(menuItemAccessVO, errorHandler, contextMap);
	} 
	
}
