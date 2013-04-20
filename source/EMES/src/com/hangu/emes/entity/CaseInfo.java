package com.hangu.emes.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("caseInfo")
public class CaseInfo extends BaseProcedureEntity {

	private static final long serialVersionUID = 3073791154580572934L;

	/**
	 * 案件号
	 */
	private String name = null;

	/**
	 * 上报时间
	 */
	private Date reportTime = null;

	/**
	 * 上报人
	 */
	private String owner = null;

	/**
	 * 案件地点
	 */
	private String location = null;

	/**
	 * 案件描述
	 */
	private String description = null;

	/*-
	 * gettings && Settings
	 */

	public Date getReportTime() {
		return reportTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
