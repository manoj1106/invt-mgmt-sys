package com.fpcs.invt.mgmt.sys.utils;

import org.apache.commons.lang3.StringUtils;

public class InvtMgmtUtil {

	private InvtMgmtUtil() {
		
	}
	
	public static boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}
	
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}
	
	public static boolean isNotNull(Object obj) {
		return (null != obj) ? true : false;
	}
	
	public static boolean isNull(Object obj) {
		return (null == obj) ? true : false;
	}
	
	public static boolean isEquals(String str1,String str2) {
		return str1.equals(str2);
	}
	
	public static boolean isNotEquals(String str1,String str2) {
		return !(str1.equals(str2));
	}
	
	public static String concatenate(Object ...objects) {
		StringBuilder concatenator = new StringBuilder();
		for(Object object : objects) {
			concatenator.append(object);
		}
		return concatenator.toString();
	}
	
	public static void sleep(long seconds) {
		try  {
			Thread.sleep(1000 * seconds);
		} catch(InterruptedException ie) {
			
		}
	}
}
