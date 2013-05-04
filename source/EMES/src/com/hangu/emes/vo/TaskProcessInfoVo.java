package com.hangu.emes.vo;

import org.springframework.stereotype.Component;

import com.hangu.workflow.vo.BaseProcedureVo;

@Component("taskProcessInfoVo")
public class TaskProcessInfoVo extends BaseProcedureVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -738732482896671793L;
	/**
	 * 流程处理决断
	 */
	private String decision = null;
	/**
	 * 流程的处理意见
	 */
	private String remark = null;

	/**
	 * 流程的处理意见
	 */
	private String feedback = null;

	/**
	 * 流程所分配的group的id
	 */
	private String groups = null;
	/**
	 * 流程索要分配的user的集合（多个人之间可以用","隔开）
	 */
	private String users = null;

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}