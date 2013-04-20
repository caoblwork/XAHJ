package com.hangu.framework.system.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hangu.framework.dao.domain.BaseEntity;

/**
 * 封装系统角色的信息
 * 
 * @author 董文烨
 * @version 1.0
 */
public class Role extends BaseEntity implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 4864787799305636856L;

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
	//private List<Model> models = new ArrayList<Model>();

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

}
