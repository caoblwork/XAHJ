package com.hangu.workflow.vo;

import java.io.Serializable;

import com.hangu.framework.vo.BaseVo;

public class DeployManagerVo extends BaseVo implements Serializable {
	/**
	 * serialUID
	 */
	private static final long serialVersionUID = 4943534671405563842L;
	/**
	 * 流程的中文描述
	 */
	private String cnName;
	/**
	 * 流程的英文描述
	 */
	private String enName;
	/**
	 * 流程的详细描述
	 */
	private String description;
	/**
	 * 流程文件的存储位置
	 */
	private String filePath;

	/**
	 * 流程部署后生成的部署ID
	 */
	private String deployId;
	/**
	 * 流程部署版本
	 */
	private String deployVersion;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}

	public String getDeployVersion() {
		return deployVersion;
	}

	public void setDeployVersion(String deployVersion) {
		this.deployVersion = deployVersion;
	}
}
