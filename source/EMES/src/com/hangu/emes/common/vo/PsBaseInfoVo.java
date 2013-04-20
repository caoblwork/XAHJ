package com.hangu.emes.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.hangu.framework.vo.BaseVo;

public class PsBaseInfoVo extends BaseVo implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * 公司名称
     */
    private String psname;
    /**
     * 法人代表
     */
    private String corporationName;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话(法人的联系电话)
     */
    private String mobilePhone;
    /**
     * 办公电话
     */
    private String officePhone;
    /**
     * 行政区编码
     */
//    private AreaInfo areaInfo;
    private String regionCode;
    private String areaName;
    
    /**
     * 企业类型
     */
    private String psclassCode;
    private String psClassName;
    /**
     * 通讯地址
     */
    private String communicateAddr;
    /**
     * 投产日期
     */
    private Date runDate;
    /**
     * 占地面积
     */
    private Double totalArea;
    
    /**
     */
    private Integer statusNew;
    
    /**
     * 污染类型
     */
    private String iType;
    private String iTypeName;
    /**
     * 备注
     */
    private String remark;

    /**
     * 企业名称的首字母的大写
     */
    private String spell;
    /*-
     * Gettings &&　Settings
     */
    public String getPsname() {
        return psname;
    }
    public void setPsname(String psname) {
        this.psname = psname;
    }
    public String getCorporationName() {
        return corporationName;
    }
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }
    public String getLinkman() {
        return linkman;
    }
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getOfficePhone() {
        return officePhone;
    }
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    public String getRegionCode() {
        return regionCode;
    }
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    public String getPsclassCode() {
        return psclassCode;
    }
    public void setPsclassCode(String psclassCode) {
        this.psclassCode = psclassCode;
    }
    public String getCommunicateAddr() {
        return communicateAddr;
    }
    public void setCommunicateAddr(String communicateAddr) {
        this.communicateAddr = communicateAddr;
    }

    public Date getRunDate() {
        return runDate;
    }
    public void setRunDate( Date runDate ) {
        this.runDate = runDate;
    }
    public Double getTotalArea() {
        return totalArea;
    }
    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }
    public String getPsClassName() {
        return psClassName;
    }
    public void setPsClassName( String psClassName ) {
        this.psClassName = psClassName;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public Integer getStatusNew() {
        return statusNew;
    }
    public void setStatusNew(Integer statusNew) {
        this.statusNew = new Integer(0);
    }
    public String getSpell() {
        return spell;
    }
    public void setSpell(String spell) {
        this.spell = spell;
    }
//    public AreaInfo getAreaInfo() {
//        return areaInfo;
//    }
//    public void setAreaInfo(AreaInfo areaInfo) {
//        this.areaInfo = areaInfo;
//    }
	/**
	 * @return the iType
	 */
	public String getiType() {
		return iType;
	}
	/**
	 * @param iType the iType to set
	 */
	public void setiType(String iType) {
		this.iType = iType;
	}
	/**
	 * @return the iTypeName
	 */
	public String getiTypeName() {
		return iTypeName;
	}
	/**
	 * @param iTypeName the iTypeName to set
	 */
	public void setiTypeName(String iTypeName) {
		this.iTypeName = iTypeName;
	}
    
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
