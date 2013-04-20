package com.hangu.framework.dao.domain;

import java.util.Date;

/**
 * 审计记录接口
 * 
 * @author 李显锋
 * @version 1.0
 * 
 */
public interface Auditable {

    /**
     * @param createBy
     *            the createBy to set
     */
    public void setCreateBy(String createBy);

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate(Date createDate);

    /**
     * 
     * @param updateBy
     *            the updateBy to set
     */
    public void setUpdateBy(String updateBy);

    /**
     * @param updateDate
     *            the updateDate to set
     */
    public void setUpdateDate(Date updateDate);
    
    /**
     * 设定版本
     */
    public void setVersion(Integer version);
    
    /**
     * 取得版本
     */
    public Integer getVersion();

    /**
     * @return the status
     */
    public String getStatus();

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status);
    

    /**
     * @return the createDate
     */
    public Date getCreateDate();
}
