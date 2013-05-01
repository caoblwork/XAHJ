package com.evalley.xahj.util;

import java.text.SimpleDateFormat;

import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json实用类，扩展封装Jackson.
 * 
 * @author Peter Wei (mailto:guangbowei@xxx.com)
 * @since 2011
 * @version 1.0.0
 */
public class JsonUtils {
	
	private static final String TAG = "JsonUtils";

	final static ObjectMapper objectMapper;

	/**
	 * 是否打印美观格式
	 */
	static boolean isPretty = true;

	static {
		objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	/**
	 * JSON串转换为Java泛型对象，可以是各种类型，此方法最为强大。用法看测试用例。
	 * 
	 * @param <T>
	 * @param jsonString
	 *            JSON字符串
	 * @param tr
	 *            TypeReference,例如: new TypeReference< List<FamousUser> >(){}
	 * @return List对象列表
	 */
	public static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {

		if (jsonString == null || "".equals(jsonString)) {
			return null;
		} else {
			try {
				return (T) objectMapper.readValue(jsonString, tr);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}
		}
		return null;
	}

	/**
	 * Java对象转Json字符串
	 * 
	 * @param object
	 *            Java对象，可以是对象，数组，List,Map等
	 * @return json 字符串
	 */
	public static String toJson(Object object) {
		String jsonString = "";
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
		return jsonString;

	}

	/**
	 * Json字符串转Java对象
	 * 
	 * @param jsonString
	 * @param c
	 * @return
	 */
	public static Object json2Object(String jsonString, Class<?> c) {

		if (jsonString == null || "".equals(jsonString)) {
			return "";
		} else {
			try {
				return objectMapper.readValue(jsonString, c);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}
		}
		return "";
	}

}