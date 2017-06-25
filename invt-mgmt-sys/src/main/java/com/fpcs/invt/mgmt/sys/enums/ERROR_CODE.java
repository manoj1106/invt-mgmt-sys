package com.fpcs.invt.mgmt.sys.enums;


public enum ERROR_CODE {
	
	//Exception Error Code starts from 10001
	HIBERNATE_EXCEPTION(10001),
	SERVICE_EXCEPTION(10002),
	JAXB_EXCEPTION(10003),
	
	//Controller layer exception starts from 20001
	
	//Service layer exception starts from 30001
	SAME_CLASS_ALREADY_EXISTS(30001),
	SAME_SECTION_ALREADY_EXISTS(30002),
	
	//DAO layer exception starts from 40001
	
	//Util layer exception starts from 50001
	MISSING_RESOURCE_EXCEPTION(50001)
	;
	
	private final Integer errorCode;
	
	private ERROR_CODE(Integer errorCode){
		this.errorCode = errorCode;
	}
	
	public Integer getErrorCode(){
		return errorCode;
	}
}
