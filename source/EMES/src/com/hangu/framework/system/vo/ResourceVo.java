package com.hangu.framework.system.vo;

import java.io.Serializable;

import com.hangu.framework.vo.BaseVo;

public class ResourceVo extends BaseVo implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -295202007008654678L;
	/**
	 * 资源名称
	 */
	private String name;
	/**
	 * 资源编码
	 */
	private String code;
	/**
	 * 资源类型
	 */
	private String type;
	/**
	 * 资源地址
	 */
	private String address;

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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
