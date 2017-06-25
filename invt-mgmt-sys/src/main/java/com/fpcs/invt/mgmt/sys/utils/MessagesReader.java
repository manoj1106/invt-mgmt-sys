/**
 * 
 */
package com.fpcs.invt.mgmt.sys.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.service.impl.MenuItemAccessServiceImpl;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;

/**
 * @author Manoj Patel
 *
 */
public class MessagesReader {

	private static final Logger logger = LoggerFactory.getLogger(MenuItemAccessServiceImpl.class);
	
	private static final String BUNDLE_NAME = "messages";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private MessagesReader() {
		
	}
	
	public static String getMessage(String key) {
		String message = null;
		try {
			message = RESOURCE_BUNDLE.getString(key);
		} catch(MissingResourceException missingResourceException) {
			logger.error("exception occured while fetching property.", missingResourceException);
			throw new InvtMgmtSysException(ERROR_CODE.MISSING_RESOURCE_EXCEPTION.getErrorCode(),missingResourceException);
		}
		return message;
	}
	
}
