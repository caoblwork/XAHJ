package com.hangu.framework.system.vo;

import java.io.Serializable;

import com.hangu.framework.vo.SearchCondition;

public class DataDictionarySearchCondition extends SearchCondition implements Serializable {

	/** 序列化ID **/
	private static final long serialVersionUID = 4846879449276508819L;

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
