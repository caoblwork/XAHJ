package com.hangu.framework.system.vo;

import java.io.Serializable;

import com.hangu.framework.vo.SearchCondition;

public class ModelSearchCondition extends SearchCondition implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 3495140280413811359L;
	/**
	 * 模块名称
	 */
	private String name;
	/**
	 * 模块编码
	 */
	private String code;
	/**
	 * 模块描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer order;

	// -------- Getting &&　Setting --------//
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
}
