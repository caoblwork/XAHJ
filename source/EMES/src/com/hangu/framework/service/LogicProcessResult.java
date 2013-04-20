package com.hangu.framework.service;

import java.io.Serializable;

import com.hangu.framework.vo.Messages;

/**
 * 逻辑处理结果
 * 
 * @author 李显锋
 * 
 */
public class LogicProcessResult implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -2394531159802303538L;

    /**
     * 逻辑处理结果对象
     */
    private Object resultObject = null;

    /**
     * 逻辑处理结果（是否成功）
     */
    private boolean success = Boolean.TRUE;

    /**
     * 逻辑处理错误集合
     */
    private Messages errors = null;

    /**
     * 逻辑处理消息集合
     */
    private Messages messages = null;

    /**
     * @return the resultObject
     */
    public Object getResultObject() {
        return resultObject;
    }

    public LogicProcessResult() {
        super();
    }

    public LogicProcessResult(Object resultObject, boolean success) {
        super();
        this.resultObject = resultObject;
        this.success = success;
    }

    public LogicProcessResult(Object resultObject) {
        super();
        this.resultObject = resultObject;
    }

    /**
     * @param resultObject the resultObject to set
     */
    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

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
     * @return the errors
     */
    public Messages getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Messages errors) {
        this.errors = errors;
    }

    /**
     * @return the messages
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
