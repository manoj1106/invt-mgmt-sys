package com.fpcs.invt.mgmt.sys.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fpcs.invt.mgmt.sys.utils.exception.ErrorHandler;

public class ObjectFactory {

	private static ObjectFactory objectFactory;
	
	private ObjectFactory() {
		
	}
	
	public static ObjectFactory getObjectFactory() {
		if(null == objectFactory) {
			objectFactory =  new ObjectFactory();
		}
		return objectFactory;
	}
	
	public Map<String , Object> getMap() {
		return new HashMap<>();
	}
	
	public List<?> getNewArrayList() {
		return new ArrayList<>();
	}
	
	public ResponseMessage getResponseMessage() {
		return new ResponseMessage();
	}
	
	public ErrorHandler getErrorHandler() {
		return new ErrorHandler();
	}
	
}
