package com.hangu.framework.system.vo;

import java.io.Serializable;

import com.hangu.framework.vo.SearchCondition;

public class ResourceSearchCondition extends SearchCondition implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 3372794597473412104L;
	/**
	 * 资源名称
	 */
	private String name=null;
	/**
	 * 资源类型
	 */
	private String type=null;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
