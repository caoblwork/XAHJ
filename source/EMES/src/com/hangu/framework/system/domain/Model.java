package com.hangu.framework.system.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hangu.framework.dao.domain.BaseEntity;

/**
 * 封装模块信息
 * 
 * @author 董文烨
 * @version 1.0
 */
public class Model extends BaseEntity implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 6430477603146980568L;
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
	/**
	 * 
	 */
	//private List<Resource> resources = new ArrayList<Resource>();

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
