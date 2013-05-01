package com.evalley.xahj.util;

import java.security.MessageDigest;

public class StringUtils {
	
	/**
	 * 判断字符串不为null且不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		if (str != null && !str.equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * 判断字符串不为null且不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * Java MD5加密
	 * 
	 * @return
	 */
	public static String MD5Encryption(String str) {
		if (isNotBlank(str)) {
			return StringUtils.MD5Encryption(str.getBytes());
		}
		return null;
	}

	/**
	 * Java MD5加密
	 * 
	 * @param b
	 *            ：需要加密的文件的byte[]，可以是文本文件，也可以是非文本文件
	 * @return
	 */
	public static String MD5Encryption(byte[] b) {
		String result = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(b);
			byte[] bResult = md.digest();
			// result = new String(bResult, "ISO-8859-1");
			result = bResult.toString();

			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < bResult.length; offset++) {
				i = bResult[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
