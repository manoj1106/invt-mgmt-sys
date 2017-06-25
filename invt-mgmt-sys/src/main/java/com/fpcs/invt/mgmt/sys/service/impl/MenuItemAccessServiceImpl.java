package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpcs.invt.mgmt.sys.constants.CommonConstants;
import com.fpcs.invt.mgmt.sys.constants.JsonConstants;
import com.fpcs.invt.mgmt.sys.constants.datapopulator.MenuItemAccessDataPopulator;
import com.fpcs.invt.mgmt.sys.dao.MenuItemAccessDAO;
import com.fpcs.invt.mgmt.sys.domain.MenuItemAccess;
import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.enums.ROLES;
import com.fpcs.invt.mgmt.sys.parser.CustomJSONParser;
import com.fpcs.invt.mgmt.sys.service.CacheService;
import com.fpcs.invt.mgmt.sys.service.MenuItemAccessService;
import com.fpcs.invt.mgmt.sys.utils.ErrorMessagesReader;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;
import com.fpcs.invt.mgmt.sys.utils.MessagesReader;
import com.fpcs.invt.mgmt.sys.utils.ResponseMessage;
import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;
import com.fpcs.invt.mgmt.sys.vo.MenuItemAccessVO;

@Service
public class MenuItemAccessServiceImpl implements MenuItemAccessService {


	private static final Logger logger = LoggerFactory.getLogger(MenuItemAccessServiceImpl.class);
	
	@Autowired
	private CacheService cacheService;

	@Autowired
	private MenuItemAccessDAO menuItemAccessDAO;

	@Override
	@Transactional
	public ResponseMessage saveMenuItemAccess(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap) {
		logger.debug("method saveMenuItemAccess() entry"); 
		ResponseMessage responseMessage = new ResponseMessage();
		Map<String,Object> messages = new HashMap<>();
		MenuItemAccess menuItemAccess = null;
		boolean updateFlag = false;
		try {
			menuItemAccess = menuItemAccessDAO.getMenuItemAccess(menuItemAccessVO.getShopId(), menuItemAccessVO.getRole());
			if(InvtMgmtUtil.isNotNull(menuItemAccess)) {
				menuItemAccess.setMenuItem(menuItemAccessVO.getMenuItem());
				updateFlag = true;
			} else {
				menuItemAccess = MenuItemAccessDataPopulator.populateMenuItemAccess(menuItemAccessVO);
			}
			boolean isSaved = menuItemAccessDAO.saveMenuItemAccess(menuItemAccess);
			if(isSaved) {
				logger.debug("menu item saved in database successfully.");
				if(updateFlag) {
					messages.put(CommonConstants.SUCCESS, 
							MessagesReader.getMessage("MenuItemAccessServiceImpl.MenuItemUpdateSuccess"));
				} else {
					logger.debug("menu item are not saved in database.");
					messages.put(CommonConstants.SUCCESS, 
							MessagesReader.getMessage("MenuItemAccessServiceImpl.MenuItemAccessSuccess"));
				}
			} else {
				messages.put(CommonConstants.ERROR, 
						MessagesReader.getMessage("MenuItemAccessServiceImpl.MenuItemAccessError"));
			}
			logger.debug("method saveMenuItemAccess() end");
		} catch(InvtMgmtSysException managementException) {
			logger.error("Error occurred while fetching data for menu item." , managementException);
			messages.put(CommonConstants.ERROR, managementException.getErrorMessage());
		} catch(Exception exception) {
			logger.error("System error occurred while fetching data from db", exception);
			messages.put(CommonConstants.ERROR, 
					ErrorMessagesReader.getErrorMessage(ERROR_CODE.SERVICE_EXCEPTION.getErrorCode()));
		}
		responseMessage.setMessages(messages);
		return responseMessage;
	}

	@Override
	@Transactional
	public Set<String> getAllowedMenues(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap) {
		logger.debug("method getAllowedMenues() entry"); 
		MenuItemAccess menuItemAccess = null;
		Set<String> allowedMenues = null;
		CustomJSONParser customJSONParser = new CustomJSONParser();
		try {
			menuItemAccess = menuItemAccessDAO.getMenuItemAccess(menuItemAccessVO.getShopId(), 
					menuItemAccessVO.getRole());
			if(InvtMgmtUtil.isNotNull(menuItemAccess)) {
				allowedMenues = customJSONParser.getAllowedMenuItems(menuItemAccess.getMenuItem());
			}
			logger.debug("method getAllowedMenues() exit"); 
		} catch(InvtMgmtSysException e) {
			logger.error("Error occurred while fetching allowed menues." , e);
		} catch (Exception e) {
			logger.error("Error occurred while fetching allowed menues." , e);
		}
		return allowedMenues;
	}

	@Override
	public Set<String> getRoles() {
		return cacheService.getRoles();
	}

	@Override
	public String getAllMenues() {
		String menu = CommonConstants.EMPTY_STRING;
		CustomJSONParser customJSONParser = new CustomJSONParser();
		try {
			menu = customJSONParser.getMenuItem(JsonConstants.JSON_FILE_NAME);
		} catch(Exception e) {
			logger.error("error occured while fetching all menues from database.",e);
		}
		return menu;
	}

	@Override
	@Transactional
	public ResponseMessage getMenuItems(MenuItemAccessVO menuItemAccessVO,ErrorHandler errorHandler,
			Map<String,Object> contextMap) {
		logger.debug("method getMenuItems() entry");
		ResponseMessage responseMessage = new ResponseMessage();
		Map<String,Object> dataMap = new HashMap<>();
		MenuItemAccess menuItemAccess = null;
		CustomJSONParser customJSONParser = new CustomJSONParser();
		try {
			if(InvtMgmtUtil.isNotNull(menuItemAccessVO) && InvtMgmtUtil.isNotNull(menuItemAccessVO.getShopId()) &&
					InvtMgmtUtil.isNotBlank(menuItemAccessVO.getRole())) {
				menuItemAccess = menuItemAccessDAO.getMenuItemAccess(menuItemAccessVO.getShopId(), menuItemAccessVO.getRole());
			} else {
				menuItemAccess = menuItemAccessDAO.getMenuItemAccess(null, ROLES.SYSTEM_ADMIN.getRole());
			}
			if(null != menuItemAccess && InvtMgmtUtil.isNotBlank(menuItemAccess.getMenuItem())) {
				dataMap.put("allowedmenues", customJSONParser.getAllowedMenuItem(menuItemAccess.getMenuItem()));
			}
			dataMap.put("allmenues", this.getAllMenues());
			responseMessage.setDataMap(dataMap);
			logger.debug("method getMenuItems() exit");
		} catch(Exception exception) {
			logger.error("error occured while fetching all menues from database.",exception);
		}
		return responseMessage;
	}

}
