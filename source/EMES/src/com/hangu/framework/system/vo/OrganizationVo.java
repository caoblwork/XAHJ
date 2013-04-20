package com.hangu.framework.system.vo;

import com.hangu.framework.vo.BaseVo;

public class OrganizationVo extends BaseVo {

	/** 序列化ID */
	private static final long serialVersionUID = 1066320810946301809L;

	/**
	 * 组织名称
	 */
	private String name = null;
	/**
	 * 上级机构ID
	 */
	private String parentId = null;

	/**
	 * 备注
	 */
	private String description = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}