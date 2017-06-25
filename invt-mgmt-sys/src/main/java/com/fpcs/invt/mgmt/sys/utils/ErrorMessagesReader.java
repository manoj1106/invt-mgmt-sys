package com.fpcs.invt.mgmt.sys.utils;


import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fpcs.invt.mgmt.sys.enums.ERROR_CODE;
import com.fpcs.invt.mgmt.sys.utils.exception.InvtMgmtSysException;

public class ErrorMessagesReader {

	private static final Logger logger = LoggerFactory.getLogger(ErrorMessagesReader.class);
	
	private static final String BUNDLE_NAME = "errormessages";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private ErrorMessagesReader() {
		
	}
	
	public static String getErrorMessage(Integer errorCode) {
		String errorMessage = null;
		try {
			errorMessage = RESOURCE_BUNDLE.getString(errorCode.toString());
		} catch(MissingResourceException missingResourceException) {
			logger.error("exception occured while fetching property.", missingResourceException);
			throw new InvtMgmtSysException(ERROR_CODE.MISSING_RESOURCE_EXCEPTION.getErrorCode(),missingResourceException);
		}
		return errorMessage;
	}
	
}
