package com.hangu.framework.system.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hangu.framework.system.domain.Model;
import com.hangu.framework.vo.BaseVo;

public class RoleVo extends BaseVo implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -3620565697045645872L;

	/**
	 * 角色英文编码
	 */
	private String code = null;

	/**
	 * 角色中文名称
	 */
	private String name = null;

	/**
	 * 角色备注
	 */
	private String description = null;

	/**
	 * 关联的模块集合
	 */
	private List<Model> models = new ArrayList<Model>();

	// -------- getting && Setting --------//
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

}
