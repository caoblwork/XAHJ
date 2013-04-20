package com.hangu.framework.system.domain;

import java.io.Serializable;

import com.hangu.framework.dao.domain.BaseEntity;

public class DataDictionary extends BaseEntity implements Serializable {

	/** 序列化ID **/
	private static final long serialVersionUID = 506848943175947058L;

	private String type;

	private String key;

	private String value;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
