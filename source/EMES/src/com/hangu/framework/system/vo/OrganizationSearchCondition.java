package com.hangu.framework.system.vo;

import java.io.Serializable;

import com.hangu.framework.vo.SearchCondition;

public class OrganizationSearchCondition extends SearchCondition implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1497413509699850991L;
	/**
	 * 部门名称
	 */
	private String name = null;
	/**
	 * 上级机构ID
	 */
	private String parentId = null;
	/**
	 * @return the name 
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
