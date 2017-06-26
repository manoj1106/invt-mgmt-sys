package com.fpcs.invt.mgmt.sys.utils;

import java.util.Map;

/**
 * @author Manoj Patel
 *
 */
public class ResponseMessage {

	private Map<String,Object> message;
	private Map<String, Object> dataMap;

	public Map<String, Object> getMessage() {
		return message;
	}

	public void setMessage(Map<String, Object> message) {
		this.message = message;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
}
