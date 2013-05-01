package com.evalley.xahj.util;

import java.util.Calendar;

public class DateUtils {

	/*
	 * 获取当前系统时间字符串
	 */
	public static String getCurrentTimeString() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR); // 获取年份
		int month = ca.get(Calendar.MONTH); // 获取月份
		int day = ca.get(Calendar.DATE); // 获取日
		int hour = ca.get(Calendar.HOUR); // 获取小时
		int minute = ca.get(Calendar.MINUTE); // 获取分
		int second = ca.get(Calendar.SECOND); // 获取秒
		int millisecond = ca.get(Calendar.MILLISECOND); // 获取毫秒
		String date = "" + year + (month + 1) + day + hour + minute + second + millisecond;
		return date;
	}
}
