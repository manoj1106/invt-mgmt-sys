package com.fpcs.invt.mgmt.sys.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class InvtMgmtUtil {

	private static final Random random = new Random();

	private static final char[] buf = new char[8];
	
	private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ch++) {
            tmp.append(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            tmp.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            tmp.append(ch);
        }
        symbols = tmp.toString().toCharArray();
    }

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

	@SuppressWarnings("unchecked")
	public static <T> String join(final T... elements) {
		return StringUtils.join(elements);
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

	public static String generateUserName() {
		String userName = String.valueOf((random.nextInt(90000000) + 10000000));
		return userName;
	}

	public static String generatePassword() {
		for (int i = 0; i < buf.length; i++) {
			buf[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}

}
