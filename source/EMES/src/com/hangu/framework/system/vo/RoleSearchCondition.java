package com.hangu.framework.system.vo;

import java.io.Serializable;
import java.util.List;

import com.hangu.framework.vo.SearchCondition;

public class RoleSearchCondition extends SearchCondition implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -4703835118865084792L;
	/**
	 * 角色名称
	 */
	private String name = null;
	/**
	 * 角色权限
	 */
	private String code = null;
	/**
	 * 用户Id
	 */
	private String userId = null;

	private List<String> names = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the names
	 */
	public List<String> getNames() {
		return names;
	}

	/**
	 * @param names
	 *            the names to set
	 */
	public void setNames(List<String> names) {
		this.names = names;
	}

}
