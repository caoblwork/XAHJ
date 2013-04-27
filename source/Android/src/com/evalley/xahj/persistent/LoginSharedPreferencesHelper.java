package com.evalley.xahj.persistent;

import android.content.Context;

import com.evalley.xahj.util.StringUtils;
import com.evalley.xahj.vo.LoginInfo;

/**
 * @Description 登录信息本地保存帮助类
 * @author 麻胜海
 * @date 2012-4-20上午10:46:50
 */
public class LoginSharedPreferencesHelper {

	/**
	 * 登陆信息
	 */
	// 登录用户名Key
	public static final String LOGIN_INFO_KEY = "loginInfo";
	// 登录用户名Key
	public static final String LOGIN_NAME_KEY = "name";
	// 登录密码Key
	public static final String LOGIN_PASSWORD_KEY = "password";
	// 登录记住密码Key
	public static final String LOGIN_REMEMBER_KEY = "remember";
	
	/**
	 * 获取登录信息
	 * @param context
	 * @return
	 */
	public static LoginInfo getLoginInfo(Context context) {
		LoginInfo loginInfo = null;
		SharedPreferencesHelper spHelper = new SharedPreferencesHelper(context, LOGIN_INFO_KEY);
		String rememberPassword = spHelper.getValue(LOGIN_REMEMBER_KEY);
		if (StringUtils.isNotBlank(rememberPassword)) {
			loginInfo = new LoginInfo();
			loginInfo.setRememberPasswd(Boolean.valueOf(rememberPassword));
			loginInfo.setLoginName(spHelper.getValue(LOGIN_NAME_KEY));
			loginInfo.setLoginPasswd(spHelper.getValue(LOGIN_PASSWORD_KEY));
		}
		
		return loginInfo;
	}
	
	/**
	 * 保存登录信息
	 * @param context
	 * @return
	 */
	public static void saveLoginInfo(Context context, LoginInfo loginInfo) {
		SharedPreferencesHelper spHelper = new SharedPreferencesHelper(context, LOGIN_INFO_KEY);
		if (loginInfo != null) {
			if (loginInfo.isRememberPasswd()) {
				spHelper.putValue(LOGIN_REMEMBER_KEY, "true");
				if (StringUtils.isNotBlank(loginInfo.getLoginName())) {
					spHelper.putValue(LOGIN_NAME_KEY, loginInfo.getLoginName());
				}
				if (StringUtils.isNotBlank(loginInfo.getLoginPasswd())) {
					spHelper.putValue(LOGIN_PASSWORD_KEY, loginInfo.getLoginPasswd());
				}
			} else {
				spHelper.putValue(LOGIN_REMEMBER_KEY, "false");
				spHelper.putValue(LOGIN_NAME_KEY, "");
				spHelper.putValue(LOGIN_PASSWORD_KEY, "");
			}
		} else {
			spHelper.putValue(LOGIN_REMEMBER_KEY, "false");
			spHelper.putValue(LOGIN_NAME_KEY, "");
			spHelper.putValue(LOGIN_PASSWORD_KEY, "");
		}
	}
	/**
	 * 修改密码后保存信息
	 * @param context
	 * @param loginInfo
	 */
	public static void saveUpdatePwdInfo(Context context, String password){
		SharedPreferencesHelper spHelper = new SharedPreferencesHelper(context, LOGIN_INFO_KEY);
		spHelper.putValue(LOGIN_PASSWORD_KEY, password);
	}
}
