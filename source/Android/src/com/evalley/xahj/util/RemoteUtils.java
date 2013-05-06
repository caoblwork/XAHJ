package com.evalley.xahj.util;

import net.tsz.afinal.http.AjaxParams;

import com.evalley.xahj.Constants;

public class RemoteUtils {
	
	/**
	 * 获取请求参数实例
	 */
	public static AjaxParams getAjaxParams() {
		// Map<String, String> source
		return new AjaxParams("pageSize", Constants.PAGE_SIZE);
	}
}
