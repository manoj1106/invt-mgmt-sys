package com.fpcs.invt.mgmt.sys.utils.exception;

import com.fpcs.invt.mgmt.sys.utils.ErrorMessagesReader;

@SuppressWarnings("serial")
public class InvtMgmtSysException extends RuntimeException {

	private final Integer errorCode;
	private final String errorMessage;
	
	public InvtMgmtSysException(Integer errorCode,Exception exception) {
		super(ErrorMessagesReader.getErrorMessage(errorCode) , exception);
		this.errorCode = errorCode;
		this.errorMessage = ErrorMessagesReader.getErrorMessage(errorCode);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
