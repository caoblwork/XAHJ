/*
 * Copyright 2005-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hangu.emes.vo;

import com.hangu.framework.vo.BaseVo;


/**
 * 污染源基本信息vo
 * 
 * @author hp
 * @version 1.0
 */
public class WryjbxxVo extends BaseVo {
    /** 序列化ID */
    private static final long serialVersionUID = -269071116769218593L;
	/** 污染源编号 */
	private java.lang.String wrybh = null;
	/** 污染源名称 */
	private java.lang.String wrymc = null;
	/** 简称 */
	private java.lang.String wryjc = null;
	/** 传真号码 */
	private java.lang.String czhm = null;
	/** 联系电话 */
	private java.lang.String lxdh = null;
	/** 组织机构 */
	private java.lang.String zzjgdm = null;
	/** 所属省份 */
	private java.lang.String sssf = null;
	/** 所属地市 */
	private java.lang.String ssds = null;
	/** 所属区县 */
	private java.lang.String ssqx = null;
	/** 所属街道 */
	private java.lang.String ssjd = null;
	/** 网格代码 */
	private java.lang.String wgdm = null;
	/** 管辖归属 */
	private java.lang.String gxgs = null;
	/** 单位类型 */
	private java.lang.String dwlx = null;
	/** 单位地址 */
	private java.lang.String dwdz = null;
	/** 邮政编码 */
	private java.lang.String yzbm = null;
	/** 法人代表 */
	private java.lang.String frdb = null;
	/** 网址 */
	private java.lang.String wz = null;
	/** 电子邮箱 */
	private java.lang.String dzyx = null;
	/** 隶属关系 */
	private java.lang.String lsgx = null;
	/** 经济类型 */
	private java.lang.String jjlx = null;
	/** 行业代码 */
	private java.lang.String hydm = null;
	/** 企业规模 */
	private java.lang.String qygm = null;
	/** 总投资 */
	private java.lang.Long ztz = null;
	/** 环保投资 */
	private java.lang.Long hbtz = null;
	/** 环保联系人 */
	private java.lang.String hblxr = null;
	/** 联系人地址 */
	private java.lang.String hblxrlxdz = null;
	/** 经度（度） */
	private java.lang.Integer jdd = null;
	/** 经度（分） */
	private java.lang.Integer jdf = null;
	/** 经度（秒） */
	private java.lang.Integer jdm = null;
	/** 纬度（度） */
	private java.lang.Integer wdd = null;
	/** 纬度（分） */
	private java.lang.Integer wdf = null;
	/** 纬度（秒） */
	private java.lang.Integer wdm = null;
	/** 工业园名称 */
	private java.lang.String szgyymc = null;
	/** 排污许可证编号 */
	private java.lang.String pwxkzbh = null;
	/** 污染源介绍 */
	private java.lang.String wryjs = null;
	/** 备注 */
	private java.lang.String bz = null;

	/**
     * @return the wrybh
     */
	public java.lang.String getWrybh() {
		return this.wrybh;
	}
	/**
     * @param wrybh the wrybh to set
     */
	public void setWrybh(java.lang.String wrybh) {
		this.wrybh = wrybh;
	}
	/**
     * @return the wrymc
     */
	public java.lang.String getWrymc() {
		return this.wrymc;
	}
	/**
     * @param wrymc the wrymc to set
     */
	public void setWrymc(java.lang.String wrymc) {
		this.wrymc = wrymc;
	}
	/**
     * @return the wryjc
     */
	public java.lang.String getWryjc() {
		return this.wryjc;
	}
	/**
     * @param wryjc the wryjc to set
     */
	public void setWryjc(java.lang.String wryjc) {
		this.wryjc = wryjc;
	}
	/**
     * @return the czhm
     */
	public java.lang.String getCzhm() {
		return this.czhm;
	}
	/**
     * @param czhm the czhm to set
     */
	public void setCzhm(java.lang.String czhm) {
		this.czhm = czhm;
	}
	/**
     * @return the lxdh
     */
	public java.lang.String getLxdh() {
		return this.lxdh;
	}
	/**
     * @param lxdh the lxdh to set
     */
	public void setLxdh(java.lang.String lxdh) {
		this.lxdh = lxdh;
	}
	/**
     * @return the zzjgdm
     */
	public java.lang.String getZzjgdm() {
		return this.zzjgdm;
	}
	/**
     * @param zzjgdm the zzjgdm to set
     */
	public void setZzjgdm(java.lang.String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	/**
     * @return the sssf
     */
	public java.lang.String getSssf() {
		return this.sssf;
	}
	/**
     * @param sssf the sssf to set
     */
	public void setSssf(java.lang.String sssf) {
		this.sssf = sssf;
	}
	/**
     * @return the ssds
     */
	public java.lang.String getSsds() {
		return this.ssds;
	}
	/**
     * @param ssds the ssds to set
     */
	public void setSsds(java.lang.String ssds) {
		this.ssds = ssds;
	}
	/**
     * @return the ssqx
     */
	public java.lang.String getSsqx() {
		return this.ssqx;
	}
	/**
     * @param ssqx the ssqx to set
     */
	public void setSsqx(java.lang.String ssqx) {
		this.ssqx = ssqx;
	}
	/**
     * @return the ssjd
     */
	public java.lang.String getSsjd() {
		return this.ssjd;
	}
	/**
     * @param ssjd the ssjd to set
     */
	public void setSsjd(java.lang.String ssjd) {
		this.ssjd = ssjd;
	}
	/**
     * @return the wgdm
     */
	public java.lang.String getWgdm() {
		return this.wgdm;
	}
	/**
     * @param wgdm the wgdm to set
     */
	public void setWgdm(java.lang.String wgdm) {
		this.wgdm = wgdm;
	}
	/**
     * @return the gxgs
     */
	public java.lang.String getGxgs() {
		return this.gxgs;
	}
	/**
     * @param gxgs the gxgs to set
     */
	public void setGxgs(java.lang.String gxgs) {
		this.gxgs = gxgs;
	}
	/**
     * @return the dwlx
     */
	public java.lang.String getDwlx() {
		return this.dwlx;
	}
	/**
     * @param dwlx the dwlx to set
     */
	public void setDwlx(java.lang.String dwlx) {
		this.dwlx = dwlx;
	}
	/**
     * @return the dwdz
     */
	public java.lang.String getDwdz() {
		return this.dwdz;
	}
	/**
     * @param dwdz the dwdz to set
     */
	public void setDwdz(java.lang.String dwdz) {
		this.dwdz = dwdz;
	}
	/**
     * @return the yzbm
     */
	public java.lang.String getYzbm() {
		return this.yzbm;
	}
	/**
     * @param yzbm the yzbm to set
     */
	public void setYzbm(java.lang.String yzbm) {
		this.yzbm = yzbm;
	}
	/**
     * @return the frdb
     */
	public java.lang.String getFrdb() {
		return this.frdb;
	}
	/**
     * @param frdb the frdb to set
     */
	public void setFrdb(java.lang.String frdb) {
		this.frdb = frdb;
	}
	/**
     * @return the wz
     */
	public java.lang.String getWz() {
		return this.wz;
	}
	/**
     * @param wz the wz to set
     */
	public void setWz(java.lang.String wz) {
		this.wz = wz;
	}
	/**
     * @return the dzyx
     */
	public java.lang.String getDzyx() {
		return this.dzyx;
	}
	/**
     * @param dzyx the dzyx to set
     */
	public void setDzyx(java.lang.String dzyx) {
		this.dzyx = dzyx;
	}
	/**
     * @return the lsgx
     */
	public java.lang.String getLsgx() {
		return this.lsgx;
	}
	/**
     * @param lsgx the lsgx to set
     */
	public void setLsgx(java.lang.String lsgx) {
		this.lsgx = lsgx;
	}
	/**
     * @return the jjlx
     */
	public java.lang.String getJjlx() {
		return this.jjlx;
	}
	/**
     * @param jjlx the jjlx to set
     */
	public void setJjlx(java.lang.String jjlx) {
		this.jjlx = jjlx;
	}
	/**
     * @return the hydm
     */
	public java.lang.String getHydm() {
		return this.hydm;
	}
	/**
     * @param hydm the hydm to set
     */
	public void setHydm(java.lang.String hydm) {
		this.hydm = hydm;
	}
	/**
     * @return the qygm
     */
	public java.lang.String getQygm() {
		return this.qygm;
	}
	/**
     * @param qygm the qygm to set
     */
	public void setQygm(java.lang.String qygm) {
		this.qygm = qygm;
	}
	/**
     * @return the ztz
     */
	public java.lang.Long getZtz() {
		return this.ztz;
	}
	/**
     * @param ztz the ztz to set
     */
	public void setZtz(java.lang.Long ztz) {
		this.ztz = ztz;
	}
	/**
     * @return the hbtz
     */
	public java.lang.Long getHbtz() {
		return this.hbtz;
	}
	/**
     * @param hbtz the hbtz to set
     */
	public void setHbtz(java.lang.Long hbtz) {
		this.hbtz = hbtz;
	}
	/**
     * @return the hblxr
     */
	public java.lang.String getHblxr() {
		return this.hblxr;
	}
	/**
     * @param hblxr the hblxr to set
     */
	public void setHblxr(java.lang.String hblxr) {
		this.hblxr = hblxr;
	}
	/**
     * @return the hblxrlxdz
     */
	public java.lang.String getHblxrlxdz() {
		return this.hblxrlxdz;
	}
	/**
     * @param hblxrlxdz the hblxrlxdz to set
     */
	public void setHblxrlxdz(java.lang.String hblxrlxdz) {
		this.hblxrlxdz = hblxrlxdz;
	}
	/**
     * @return the jdd
     */
	public java.lang.Integer getJdd() {
		return this.jdd;
	}
	/**
     * @param jdd the jdd to set
     */
	public void setJdd(java.lang.Integer jdd) {
		this.jdd = jdd;
	}
	/**
     * @return the jdf
     */
	public java.lang.Integer getJdf() {
		return this.jdf;
	}
	/**
     * @param jdf the jdf to set
     */
	public void setJdf(java.lang.Integer jdf) {
		this.jdf = jdf;
	}
	/**
     * @return the jdm
     */
	public java.lang.Integer getJdm() {
		return this.jdm;
	}
	/**
     * @param jdm the jdm to set
     */
	public void setJdm(java.lang.Integer jdm) {
		this.jdm = jdm;
	}
	/**
     * @return the wdd
     */
	public java.lang.Integer getWdd() {
		return this.wdd;
	}
	/**
     * @param wdd the wdd to set
     */
	public void setWdd(java.lang.Integer wdd) {
		this.wdd = wdd;
	}
	/**
     * @return the wdf
     */
	public java.lang.Integer getWdf() {
		return this.wdf;
	}
	/**
     * @param wdf the wdf to set
     */
	public void setWdf(java.lang.Integer wdf) {
		this.wdf = wdf;
	}
	/**
     * @return the wdm
     */
	public java.lang.Integer getWdm() {
		return this.wdm;
	}
	/**
     * @param wdm the wdm to set
     */
	public void setWdm(java.lang.Integer wdm) {
		this.wdm = wdm;
	}
	/**
     * @return the szgyymc
     */
	public java.lang.String getSzgyymc() {
		return this.szgyymc;
	}
	/**
     * @param szgyymc the szgyymc to set
     */
	public void setSzgyymc(java.lang.String szgyymc) {
		this.szgyymc = szgyymc;
	}
	/**
     * @return the pwxkzbh
     */
	public java.lang.String getPwxkzbh() {
		return this.pwxkzbh;
	}
	/**
     * @param pwxkzbh the pwxkzbh to set
     */
	public void setPwxkzbh(java.lang.String pwxkzbh) {
		this.pwxkzbh = pwxkzbh;
	}
	/**
     * @return the wryjs
     */
	public java.lang.String getWryjs() {
		return this.wryjs;
	}
	/**
     * @param wryjs the wryjs to set
     */
	public void setWryjs(java.lang.String wryjs) {
		this.wryjs = wryjs;
	}
	/**
     * @return the bz
     */
	public java.lang.String getBz() {
		return this.bz;
	}
	/**
     * @param bz the bz to set
     */
	public void setBz(java.lang.String bz) {
		this.bz = bz;
	}
}

