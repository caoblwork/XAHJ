package com.evalley.xahj.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @Description SharedPreferences工具类
 * @author Evalley
 * @date 2011-9-14 下午06:19:57
 */
public class SharedPreferencesHelper {
	private SharedPreferences sp;
	private Editor editor;
	private Context context;

	/**
	 * 构造函数
	 * @param c
	 * @param name
	 */
	public SharedPreferencesHelper(Context c, String name) {
		context = c;
		sp = context.getSharedPreferences(name, 0);
		editor = sp.edit();
	}

	/**
	 * 存入键值对
	 * @param key
	 * @param value
	 */
	public void putValue(String key, String value) {
		editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * 根据键，取出值
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return sp.getString(key, null);
	}
}
