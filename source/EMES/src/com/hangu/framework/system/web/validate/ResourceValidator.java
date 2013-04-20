package com.hangu.framework.system.web.validate;

import java.io.Serializable;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hangu.framework.system.vo.ResourceVo;
import com.hangu.framework.web.validate.BaseValidator;

public class ResourceValidator extends BaseValidator<ResourceVo> implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -3057183945274925290L;
	/**
	 * 验证页面输入的信息
	 */
	public void validate(Object target, Errors errors) {
		// 必须输入验证
		ValidationUtils.rejectIfEmpty(errors, "name", "errors.required", new String[] { "名称" });
		ValidationUtils.rejectIfEmpty(errors, "type", "errors.required", new String[] { "类型" });
		ValidationUtils.rejectIfEmpty(errors, "status", "errors.required", new String[] { "状态" });
		if (errors.hasErrors()) {
			return;
		}
	}
}
