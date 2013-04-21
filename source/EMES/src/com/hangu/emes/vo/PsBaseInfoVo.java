package com.hangu.emes.vo;

import java.io.Serializable;

import com.hangu.framework.vo.BaseVo;

public class PsBaseInfoVo extends BaseVo implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * 企业编码
     */
    private String psCode;
    /**
     * 企业名称
     */
    private String psName;
    /**
     * 行政区划
     */
    private Long regionCode;
    /**
     * 行政区划名称
     */
    private String regionName;
    /**
     * 企业类型
     */
    private String psType;
    /**
     * 监测级别
     */
    private String monitorLevel;
    /**
     * 企业地址
     */
    private String psaddress;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 企业法人
     */
    private String corporation;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 电话
     */
    private String tel;
    /**
     * 传真
     */
    private String fax;
    /**
     * 监测类别
     */
    private String  monitorType;
    /**
     * 是否是在线监控企业
     */
    private String isOnlineEnter;
    /**
     * 是否是视频监控企业
     */
    private Boolean isVideoEnter;
	
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	public String getPsName() {
		return psName;
	}
	public void setPsName(String psName) {
		this.psName = psName;
	}
	public Long getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(Long regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getPsType() {
		return psType;
	}
	public void setPsType(String psType) {
		this.psType = psType;
	}
	public String getMonitorLevel() {
		return monitorLevel;
	}
	public void setMonitorLevel(String monitorLevel) {
		this.monitorLevel = monitorLevel;
	}
	public String getPsaddress() {
		return psaddress;
	}
	public void setPsaddress(String psaddress) {
		this.psaddress = psaddress;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMonitorType() {
		return monitorType;
	}
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}
	public String getIsOnlineEnter() {
		return isOnlineEnter;
	}
	public void setIsOnlineEnter(String isOnlineEnter) {
		this.isOnlineEnter = isOnlineEnter;
	}
	public Boolean getIsVideoEnter() {
		return isVideoEnter;
	}
	public void setIsVideoEnter(Boolean isVideoEnter) {
		this.isVideoEnter = isVideoEnter;
	}
    
}
