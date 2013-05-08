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
package com.hangu.emes.vo;

import com.hangu.framework.vo.BaseVo;

/**
 * CaseInfo值对象
 * 
 * @author 曹保利
 * @version 1.0
 */
public class CaseInfoVo extends BaseVo {
	/** 序列化ID */
	private static final long serialVersionUID = -1765067789105954284L;
	/** 案由 */
	private String simpleReason = null;
	/** 案件编号 */
	private String caseId = null;
	/** 污染源名称 */
	private String partyName = null;
	/** 污染源地址 */
	private String partyAddress = null;
	/** 污染源法人 */
	private String partyLegalPerson = null;
	/** 当事人职位 */
	private String partyDuty = null;
	/** 当事人联系电话 */
	private String partyPhone = null;
	/** 当事人邮政编码 */
	private String partyPostcode = null;
	/** 流程实例ID */
	private String pid = null;
	/** 发起人ID */
	private String launcherId = null;
	/** 部署ID */
	private String deployId = null;

	/**
	 * @return the simpleReason
	 */
	public String getSimpleReason() {
		return this.simpleReason;
	}

	/**
	 * @param simpleReason
	 *            the simpleReason to set
	 */
	public void setSimpleReason(String simpleReason) {
		this.simpleReason = simpleReason;
	}

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return this.caseId;
	}

	/**
	 * @param caseId
	 *            the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return this.partyName;
	}

	/**
	 * @param partyName
	 *            the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the partyAddress
	 */
	public String getPartyAddress() {
		return this.partyAddress;
	}

	/**
	 * @param partyAddress
	 *            the partyAddress to set
	 */
	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	/**
	 * @return the partyLegalPerson
	 */
	public String getPartyLegalPerson() {
		return this.partyLegalPerson;
	}

	/**
	 * @param partyLegalPerson
	 *            the partyLegalPerson to set
	 */
	public void setPartyLegalPerson(String partyLegalPerson) {
		this.partyLegalPerson = partyLegalPerson;
	}

	/**
	 * @return the partyDuty
	 */
	public String getPartyDuty() {
		return this.partyDuty;
	}

	/**
	 * @param partyDuty
	 *            the partyDuty to set
	 */
	public void setPartyDuty(String partyDuty) {
		this.partyDuty = partyDuty;
	}

	/**
	 * @return the partyPhone
	 */
	public String getPartyPhone() {
		return this.partyPhone;
	}

	/**
	 * @param partyPhone
	 *            the partyPhone to set
	 */
	public void setPartyPhone(String partyPhone) {
		this.partyPhone = partyPhone;
	}

	/**
	 * @return the partyPostcode
	 */
	public String getPartyPostcode() {
		return this.partyPostcode;
	}

	/**
	 * @param partyPostcode
	 *            the partyPostcode to set
	 */
	public void setPartyPostcode(String partyPostcode) {
		this.partyPostcode = partyPostcode;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return this.pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the launcherId
	 */
	public String getLauncherId() {
		return this.launcherId;
	}

	/**
	 * @param launcherId
	 *            the launcherId to set
	 */
	public void setLauncherId(String launcherId) {
		this.launcherId = launcherId;
	}

	/**
	 * @return the deployId
	 */
	public String getDeployId() {
		return this.deployId;
	}

	/**
	 * @param deployId
	 *            the deployId to set
	 */
	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
}
