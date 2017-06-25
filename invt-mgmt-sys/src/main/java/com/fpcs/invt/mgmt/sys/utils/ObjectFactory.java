package com.fpcs.invt.mgmt.sys.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String , Object> getMessageMap() {
		return new HashMap<>();
	}
	
	public List<?> getNewArrayList() {
		return new ArrayList<>();
	}
	
}
