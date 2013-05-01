/*
 * Copyright 2005-2010 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.hangu.emes.entity;

import com.hangu.framework.dao.domain.BaseEntity;

/**
 * SupervisoryTask实体对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public class SupervisoryTask extends BaseEntity {
	/** 序列化ID */
	private static final long serialVersionUID = 3735344757994839419L;
	/** 名称 */
	private java.lang.String name = null;
	/** 案件类型 */
	private java.lang.String type = null;
	/** 污染源ID */
	private java.lang.String pollutantSourceId = null;
	/** 监察项目 */
	private java.lang.String monitorItem = null;
	/** 任务进度 */
	private java.lang.String progress = null;
	/** 创建人 */
	private java.lang.String creator = null;
	/** 执法人 */
	private java.lang.String executor = null;

	/**
	 * @return the name
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public java.lang.String getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * @return the pollutantSourceId
	 */
	public java.lang.String getPollutantSourceId() {
		return this.pollutantSourceId;
	}

	/**
	 * @param pollutantSourceId
	 *            the pollutantSourceId to set
	 */
	public void setPollutantSourceId(java.lang.String pollutantSourceId) {
		this.pollutantSourceId = pollutantSourceId;
	}

	/**
	 * @return the monitorItem
	 */
	public java.lang.String getMonitorItem() {
		return this.monitorItem;
	}

	/**
	 * @param monitorItem
	 *            the monitorItem to set
	 */
	public void setMonitorItem(java.lang.String monitorItem) {
		this.monitorItem = monitorItem;
	}

	/**
	 * @return the progress
	 */
	public java.lang.String getProgress() {
		return this.progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(java.lang.String progress) {
		this.progress = progress;
	}

	/**
	 * @return the creator
	 */
	public java.lang.String getCreator() {
		return this.creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}

	/**
	 * @return the executor
	 */
	public java.lang.String getExecutor() {
		return this.executor;
	}

	/**
	 * @param executor
	 *            the executor to set
	 */
	public void setExecutor(java.lang.String executor) {
		this.executor = executor;
	}
}
