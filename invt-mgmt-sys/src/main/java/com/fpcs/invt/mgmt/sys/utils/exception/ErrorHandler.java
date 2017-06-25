package com.fpcs.invt.mgmt.sys.utils.exception;

import com.fpcs.invt.mgmt.sys.utils.ErrorMessagesReader;
import com.fpcs.invt.mgmt.sys.utils.InvtMgmtUtil;

public class ErrorHandler {

	private String errorMessage;
	private Integer errorCode;
	
	public ErrorHandler(){
		
	}
	
	public ErrorHandler(Integer errorCode){
		this.errorCode = errorCode;
		this.errorMessage = ErrorMessagesReader.getErrorMessage(errorCode);
	}

	public ErrorHandler(Integer errorCode,String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public void setError(Integer errorCode){
		this.errorCode = errorCode;
		this.errorMessage = ErrorMessagesReader.getErrorMessage(errorCode);
	}
	
	public boolean hasError(){
		return InvtMgmtUtil.isNotBlank(this.errorMessage);
	}

}
