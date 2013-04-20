package com.hangu.emes.entity;

import java.util.Date;

import javax.validation.constraints.Future;

import org.springframework.stereotype.Component;

/**
 * 流程申请处理
 * 
 * @author 曹保利
 * 
 */
@Component("apply")
public class Apply extends BaseProcedureEntity {

	private static final long serialVersionUID = -2098195599781080912L;
	/**
	 * 请假开始时间
	 */
	@Future
	private Date startDate;
	/**
	 * 请假结束时间
	 */
	@Future
	private Date endDate;
	/**
	 * 请假类型
	 */
	private String type;
	/**
	 * 请假原因
	 */
	private String reason;

	/**
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}