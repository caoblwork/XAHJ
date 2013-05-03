package com.evalley.xahj.cases;

import java.io.Serializable;

/**
 * @Description 播放列表项类
 * @author 麻胜海
 * @date 2011-11-15上午10:57:27
 */
public class PlayListItem implements Serializable {
	
	private static final long serialVersionUID = -9211569127612089766L;
	// 序号
	private int sn;
	// 名称
	private String name;
	// 大小
	private String size;
	// 路径
	private String path;
	// 是否删除
	private boolean delete;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}
