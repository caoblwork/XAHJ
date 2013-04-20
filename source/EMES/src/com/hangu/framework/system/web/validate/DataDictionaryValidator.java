package com.hangu.framework.system.web.validate;

import java.io.Serializable;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hangu.framework.system.vo.DataDictionaryVo;
import com.hangu.framework.web.validate.BaseValidator;

public class DataDictionaryValidator extends BaseValidator<DataDictionaryVo> implements Serializable {

	/** 序列化ID */
	private static final long serialVersionUID = -6657880128636176377L;

	public void validate(Object target, Errors errors) {
		// 必须输入验证
		ValidationUtils.rejectIfEmpty(errors, "type", "errors.required", new String[] { "类型" });
		ValidationUtils.rejectIfEmpty(errors, "key", "errors.required", new String[] { "键" });
		ValidationUtils.rejectIfEmpty(errors, "value", "errors.required", new String[] { "值" });
		if (errors.hasErrors()) {
			return;
		}
	}
}
