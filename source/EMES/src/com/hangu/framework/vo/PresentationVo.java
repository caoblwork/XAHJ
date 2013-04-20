package com.hangu.framework.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * 页面显示用VO
 * 
 * @author 曹保利
 * @version 1.0
 * 
 */
public class PresentationVo implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1811940397727188284L;

    /**
     * 处理是否成功
     */
    private boolean success = Boolean.TRUE;

    /**
     * 错误消息集合
     */
    private Messages errorMessages = new Messages();

    /**
     * 消息集合
     */
    private Messages infoMessages = new Messages();

    /**
     * 项目错误集合
     */
    private List<ObjectError> objectErrors;

    /**
     * 总记录数
     */
    private Integer totalRecords;

    /**
     * 记录集合
     */
    private List<BaseVo> records;

    /**
     * 单记录数据对象
     */
    private BaseVo voModel;

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the totalRecords
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    /**
     * @param totalRecords the totalRecords to set
     */
    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * @return the records
     */
    public List<BaseVo> getRecords() {
        return records;
    }

    /**
     * @param records the records to set
     */
    public void setRecords(List<BaseVo> records) {
        this.records = records;
    }

    /**
     * @return the voModel
     */
    public BaseVo getVoModel() {
        return voModel;
    }

    /**
     * @param voModel the voModel to set
     */
    public void setVoModel(BaseVo voModel) {
        this.voModel = voModel;
    }

    /**
     * @return the errorMessages
     */
    public Messages getErrorMessages() {
        return errorMessages;
    }

    /**
     * @param errorMessages the errorMessages to set
     */
    public void setErrorMessages(Messages errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * @return the infoMessages
     */
    public Messages getInfoMessages() {
        return infoMessages;
    }

    /**
     * @param infoMessages the infoMessages to set
     */
    public void setInfoMessages(Messages infoMessages) {
        this.infoMessages = infoMessages;
    }

    /**
     * @return the objectErrors
     */
    public List<ObjectError> getObjectErrors() {
        return objectErrors;
    }

    /**
     * @param objectErrors the objectErrors to set
     */
    public void setObjectErrors(List<ObjectError> objectErrors) {
        this.objectErrors = objectErrors;
    }

}
