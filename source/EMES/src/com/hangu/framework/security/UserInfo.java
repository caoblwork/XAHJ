package com.hangu.framework.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.hangu.framework.system.vo.RoleVo;

public class UserInfo extends User {

	/* 序列化ID */
	private static final long serialVersionUID = 6851159453225762314L;

	/**
	 * 登录时间
	 */
	private Date loginTime = null;

	/**
	 * 登录IP地址
	 */
	private String ipAddress = null;

	/**
	 * 真实姓名
	 */
	private String realName = null;

	/**
	 * UserID
	 */
	private String userId = null;

	/**
	 * 所属机构ID
	 */
	private String organId = null;

	/**
	 * 所属机构名称
	 */
	private String organName = null;
	/**
	 * 角色集合
	 */
	private List<RoleVo> roleList = null;

	/**
	 * ###
	 * 
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	// -------- Getting && Setting --------//

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public List<RoleVo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleVo> roleList) {
		this.roleList = roleList;
	}

}
