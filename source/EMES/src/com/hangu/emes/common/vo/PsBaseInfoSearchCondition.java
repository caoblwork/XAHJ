package com.hangu.emes.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.hangu.framework.vo.SearchCondition;

public class PsBaseInfoSearchCondition extends SearchCondition implements Serializable {
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
     * 行政区编码
     */
    private String regionCode;
    
    /**
     * 企业类型
     */
    private String psclassCode;
    /**
     * 通讯地址
     */
    private String communicateAddr;
    /**
     * 投产日期
     */
    private Date runDate;
    /**
     * 占地面积(如果需要模糊查询)
     */
    private Double totalArea;
    /**
     * 企业地址
     */
    private String psaddress;
    public String getPsaddress() {
		return psaddress;
	}
	public void setPsaddress(String psaddress) {
		this.psaddress = psaddress;
	}
	/**
     * 
     */
    private Date operationTimeBegin;
    private Date operationTimeEnd;
    
    /**
     * 污染类型
     */
    private String iType;
    /*-
     * Gettings && Settings
     */
    
    public String getPsname() {
        return psname;
    }
    public void setPsname( String psname ) {
        this.psname = psname;
    }
    public String getCorporationName() {
        return corporationName;
    }
    public void setCorporationName( String corporationName ) {
        this.corporationName = corporationName;
    }
    public String getLinkman() {
        return linkman;
    }
    public void setLinkman( String linkman ) {
        this.linkman = linkman;
    }
    public String getRegionCode() {
        return regionCode;
    }
    public void setRegionCode( String regionCode ) {
        this.regionCode = regionCode;
    }
    public String getPsclassCode() {
        return psclassCode;
    }
    public void setPsclassCode( String psclassCode ) {
        this.psclassCode = psclassCode;
    }
    public String getCommunicateAddr() {
        return communicateAddr;
    }
    public void setCommunicateAddr( String communicateAddr ) {
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
    public void setTotalArea( Double totalArea ) {
        this.totalArea = totalArea;
    }
    public Date getOperationTimeBegin() {
        return operationTimeBegin;
    }
    public void setOperationTimeBegin(Date operationTimeBegin) {
        this.operationTimeBegin = operationTimeBegin;
    }
    public Date getOperationTimeEnd() {
        return operationTimeEnd;
    }
    public void setOperationTimeEnd(Date operationTimeEnd) {
        this.operationTimeEnd = operationTimeEnd;
    }
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
    
}
