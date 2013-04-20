package com.hangu.emes.vo;

import java.io.Serializable;

import com.hangu.framework.vo.BaseVo;

/**
 * <任务>表现层实体
 * 
 * @author 曹保利
 * 
 */
public class SupervisoryTaskVo extends BaseVo implements Serializable {
	/**
	 * serialUID
	 */
	private static final long serialVersionUID = -3843035113846207068L;
	/**
	 * 任务名称
	 */
	private String name;
	/**
	 * 任务类型
	 */
	private String type;
	/**
	 * 污染源ID
	 */
	private String pollutantSourceId;
	/**
	 * 监察项目
	 */
	private String monitorItem;
	/**
	 * 任务进度
	 */
	private String progress;
	/**
	 * 任务创建者
	 */
	private String creator;
	/**
	 * 任务执行者
	 */
	private String executor;

	/* Gettings && Settings */

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
	 * @return the pollutantSourceId
	 */
	public String getPollutantSourceId() {
		return pollutantSourceId;
	}

	/**
	 * @param pollutantSourceId
	 *            the pollutantSourceId to set
	 */
	public void setPollutantSourceId(String pollutantSourceId) {
		this.pollutantSourceId = pollutantSourceId;
	}

	/**
	 * @return the monitorItem
	 */
	public String getMonitorItem() {
		return monitorItem;
	}

	/**
	 * @param monitorItem
	 *            the monitorItem to set
	 */
	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem;
	}

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the executor
	 */
	public String getExecutor() {
		return executor;
	}

	/**
	 * @param executor
	 *            the executor to set
	 */
	public void setExecutor(String executor) {
		this.executor = executor;
	}

}
