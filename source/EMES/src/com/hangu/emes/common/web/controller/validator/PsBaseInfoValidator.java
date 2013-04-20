package com.hangu.emes.common.web.controller.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hangu.emes.common.vo.PsBaseInfoVo;
import com.hangu.framework.web.validate.BaseValidator;

public class PsBaseInfoValidator extends BaseValidator<PsBaseInfoVo> {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1182650055031276270L;
    /**
     * 服务器段验证
     */
    public void validate(Object target, Errors errors) {
        // 必须输入验证
    	PsBaseInfoVo psBaseInfoVo = (PsBaseInfoVo)target;
        ValidationUtils.rejectIfEmpty(errors, "psname", "errors.required", new String[]{"公司名称"});
        //ValidationUtils.rejectIfEmpty(errors, "spell", "errors.required", new String[]{"公司名称首字母大写组合"});
        ValidationUtils.rejectIfEmpty(errors, "corporationName", "errors.required", new String[]{"公司法人"});
        ValidationUtils.rejectIfEmpty(errors, "linkman", "errors.required", new String[]{"公司联系人"});
        ValidationUtils.rejectIfEmpty(errors, "officePhone", "errors.required", new String[]{"联系电话"});
        ValidationUtils.rejectIfEmpty(errors, "regionCode", "errors.required", new String[]{"行政区域"});
        ValidationUtils.rejectIfEmpty(errors, "psclassCode", "errors.required", new String[]{"企业类型"});
        ValidationUtils.rejectIfEmpty(errors, "runDate", "errors.required", new String[]{"投产日期"});

        if (errors.hasErrors()) {
            return;
        }
        //对属性增加验证功能
        if (psBaseInfoVo.getPsname().getBytes().length > 120){
        	errors.rejectValue("psname", null, "公司名称信息过长,最多可输入60个字符");
        }
        //通讯地址
        if (StringUtils.isNotBlank(psBaseInfoVo.getCommunicateAddr())){
        	if (psBaseInfoVo.getCommunicateAddr().getBytes().length > 120){
            	errors.rejectValue("communicateAddr", null, "通讯地址信息过长,最多可输入60个字符");
            }
        }
    }
}
