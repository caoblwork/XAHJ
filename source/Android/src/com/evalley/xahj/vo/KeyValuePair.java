package com.evalley.xahj.vo;

/**
 * @Description 键值对类
 * @author Evalley
 * @date 2011-11-2下午3:53:51
 */
public class KeyValuePair {
	// 键
	private String key;
	// 值
	private String value;
	
	public KeyValuePair(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	// 为什么要重写toString()呢？因为适配器在显示数据的时候，如果传入适配器的对象不是字符串的情况下，直接就使用对象.toString()
	@Override
	public String toString() {
		return value;
	}
}
