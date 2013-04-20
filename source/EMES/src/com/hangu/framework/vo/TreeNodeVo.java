package com.hangu.framework.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeVo extends BaseVo implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1080055318119119526L;

	/**
	 * 树节点的text显示值
	 */
	private String name;

	/**
	 * XX
	 */
	private Boolean isParent = Boolean.FALSE;

	/**
	 * 装载子元素
	 */
	private List<TreeNodeVo> children = new ArrayList<TreeNodeVo>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TreeNodeVo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNodeVo> children) {
		this.children = children;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

}
