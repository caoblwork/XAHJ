package com.hangu.emes.entity;

import org.springframework.stereotype.Component;

/**
 * 流程结点的审核处理
 * 
 * @author 曹保利
 * 
 */
@Component("audit")
public class Audit extends BaseProcedureEntity {

	private static final long serialVersionUID = -6080720285444020148L;
	/**
	 * 流程处理决断
	 */
	private String decision = null;
	/**
	 * 流程的处理意见
	 */
	private String remark = null;

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

}
