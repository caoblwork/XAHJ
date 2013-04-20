package com.hangu.framework.system.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hangu.framework.system.domain.Resource;
import com.hangu.framework.vo.BaseVo;

public class ModelVo extends BaseVo implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 5827599966747583465L;
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
	private List<Resource> resources = new ArrayList<Resource>();

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

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
