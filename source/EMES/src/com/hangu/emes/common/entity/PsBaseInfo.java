package com.hangu.emes.common.entity;

import java.util.Date;

import com.hangu.framework.dao.domain.BaseEntity;

/**
 * Psbaseinfo entity.
 * 
 * @author ffy
 */

public class PsBaseInfo extends BaseEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4866240078760590023L;
    // Fields
    // private String pscode;
    private String psname;
    private String psnumber;
    /**
     * 行政区编码
     */
    private String regionCode;
    private String registTypeCode;
    private String unitTypeCode;
    private String psscaleCode;
    private String subjectionRelationCode;
    private String industyTypeCode;
    private String valleyCode;
    /**
     * 污控级别编码
     */
    private Integer attentionDegreeCode;
    private String psaddress;
    private Double longitude;
    private Double latitude;
    private String psenvironmentDept;
    private String environmentProncipal;
    private Integer environmentMans;
    private String corporationCode;
    private String corporationName;
    private Date   runDate;
    private String openAcocuntBank;
    private String bankAccount;
    private String pswebsite;
    private String officePhone;
    private String fax;
    private String mobilePhone;
    private String email;
    private String postalCode;
    private String communicateAddr;
    private String areaCode;
    /**
     * 企业类型编码
     */
    private String psclassCode;
    
    private String linkman;
    private String comment;
    private Integer checkStatus;
    private Integer statusNew = 0;
    private Integer ifAlreadyOnLine;
    private Integer onlineStatus;
    private Integer disposeTypeCode;
    private Integer ifThirtyTenthousandkilowat;
    private Double totalArea;
    private Integer isMonitor;
    private Integer buildStatus;
    private String photo;
    private Date updateDate;
    private String spell;
    private String iType;
    /**
     * 备注
     */
    private String remark;
    // Property accessors
    /**
     * 关联字段 areaInfo 用来维护AreaCode字段
     */
//    private AreaInfo areaInfo;
    /*-
     * Gettings && Settings
     */
    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public Integer getStatusNew() {
        return statusNew;
    }

    public void setStatusNew(Integer statusNew) {
        this.statusNew = statusNew;
    }

    public String getPsname() {
        return this.psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }

    public String getPsnumber() {
        return this.psnumber;
    }

    public void setPsnumber(String psnumber) {
        this.psnumber = psnumber;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegistTypeCode() {
        return this.registTypeCode;
    }

    public void setRegistTypeCode(String registTypeCode) {
        this.registTypeCode = registTypeCode;
    }

    public String getUnitTypeCode() {
        return this.unitTypeCode;
    }

    public void setUnitTypeCode(String unitTypeCode) {
        this.unitTypeCode = unitTypeCode;
    }

    public String getPsscaleCode() {
        return this.psscaleCode;
    }

    public void setPsscaleCode(String psscaleCode) {
        this.psscaleCode = psscaleCode;
    }

    public String getSubjectionRelationCode() {
        return this.subjectionRelationCode;
    }

    public void setSubjectionRelationCode(String subjectionRelationCode) {
        this.subjectionRelationCode = subjectionRelationCode;
    }

    public String getIndustyTypeCode() {
        return this.industyTypeCode;
    }

    public void setIndustyTypeCode(String industyTypeCode) {
        this.industyTypeCode = industyTypeCode;
    }

    public String getValleyCode() {
        return this.valleyCode;
    }

    public void setValleyCode(String valleyCode) {
        this.valleyCode = valleyCode;
    }

    public Integer getAttentionDegreeCode() {
        return this.attentionDegreeCode;
    }

    public void setAttentionDegreeCode(Integer attentionDegreeCode) {
        this.attentionDegreeCode = attentionDegreeCode;
    }

    public String getPsaddress() {
        return this.psaddress;
    }

    public void setPsaddress(String psaddress) {
        this.psaddress = psaddress;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPsenvironmentDept() {
        return this.psenvironmentDept;
    }

    public void setPsenvironmentDept(String psenvironmentDept) {
        this.psenvironmentDept = psenvironmentDept;
    }

    public String getEnvironmentProncipal() {
        return this.environmentProncipal;
    }

    public void setEnvironmentProncipal(String environmentProncipal) {
        this.environmentProncipal = environmentProncipal;
    }

    public Integer getEnvironmentMans() {
        return this.environmentMans;
    }

    public void setEnvironmentMans(Integer environmentMans) {
        this.environmentMans = environmentMans;
    }

    public String getCorporationCode() {
        return this.corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getCorporationName() {
        return this.corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getIType() {
        return iType;
    }

    public void setIType(String type) {
        iType = type;
    }

    public String getOpenAcocuntBank() {
        return this.openAcocuntBank;
    }

    public void setOpenAcocuntBank(String openAcocuntBank) {
        this.openAcocuntBank = openAcocuntBank;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPswebsite() {
        return this.pswebsite;
    }

    public void setPswebsite(String pswebsite) {
        this.pswebsite = pswebsite;
    }

    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCommunicateAddr() {
        return this.communicateAddr;
    }

    public void setCommunicateAddr(String communicateAddr) {
        this.communicateAddr = communicateAddr;
    }

    public String getLinkman() {
        return this.linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCheckStatus() {
        return this.checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getIfAlreadyOnLine() {
        return this.ifAlreadyOnLine;
    }

    public void setIfAlreadyOnLine(Integer ifAlreadyOnLine) {
        this.ifAlreadyOnLine = ifAlreadyOnLine;
    }

    public Integer getOnlineStatus() {
        return this.onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getDisposeTypeCode() {
        return this.disposeTypeCode;
    }

    public void setDisposeTypeCode(Integer disposeTypeCode) {
        this.disposeTypeCode = disposeTypeCode;
    }

    public Integer getIfThirtyTenthousandkilowat() {
        return this.ifThirtyTenthousandkilowat;
    }

    public void setIfThirtyTenthousandkilowat(Integer ifThirtyTenthousandkilowat) {
        this.ifThirtyTenthousandkilowat = ifThirtyTenthousandkilowat;
    }

    public Double getTotalArea() {
        return this.totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getIsMonitor() {
        return this.isMonitor;
    }

    public void setIsMonitor(Integer isMonitor) {
        this.isMonitor = isMonitor;
    }

    public Integer getBuildStatus() {
        return this.buildStatus;
    }

    public void setBuildStatus(Integer buildStatus) {
        this.buildStatus = buildStatus;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSpell() {
        return this.spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPsclassCode() {
        return psclassCode;
    }

    public void setPsclassCode(String psclassCode) {
        this.psclassCode = psclassCode;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

//    public AreaInfo getAreaInfo() {
//        return areaInfo;
//    }
//
//    public void setAreaInfo(AreaInfo areaInfo) {
//        this.areaInfo = areaInfo;
//    }

    
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