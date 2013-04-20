package com.hangu.emes.vo;

import java.io.Serializable;

import com.hangu.framework.vo.BaseVo;

public class BaseProcedureVo extends BaseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5698256948846906574L;

	/**
	 * 流程处理分流标志
	 */
	private String action = null;

	/**
	 * 流程部署标识
	 */
	private String processDeployId;
	/**
	 * 流程部署标识
	 */
	private String processDefinitionId;
	/**
	 * 流程实例ID
	 */
	private String processInstanceId;
	/**
	 * 流程发起人
	 */
	private String processLaunchId;
	/**
	 * 绑定业务id
	 */
	private String processId;
	/**
	 * 任务结点id
	 */
	private String taskId;

	public BaseProcedureVo() {
		super();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getProcessDeployId() {
		return processDeployId;
	}

	public void setProcessDeployId(String processDeployId) {
		this.processDeployId = processDeployId;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessLaunchId() {
		return processLaunchId;
	}

	public void setProcessLaunchId(String processLaunchId) {
		this.processLaunchId = processLaunchId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
