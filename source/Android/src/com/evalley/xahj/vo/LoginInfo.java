package com.evalley.xahj.vo;

/**
 * @Description ��¼��Ϣ��
 * @author ��ʤ��
 * @date 2011-9-13 ����04:25:25
 */
public class LoginInfo {
	
	// �û���
	private String loginName;
	// ����
	private String loginPasswd;
	// ��ס����
	private boolean rememberPasswd;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPasswd() {
		return loginPasswd;
	}
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}
	public boolean isRememberPasswd() {
		return rememberPasswd;
	}
	public void setRememberPasswd(boolean rememberPasswd) {
		this.rememberPasswd = rememberPasswd;
	}
}
