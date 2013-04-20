package com.hangu.framework.system.web.validate;

import java.io.Serializable;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hangu.framework.system.vo.OrganizationVo;
import com.hangu.framework.web.validate.BaseValidator;

public class OrganizationValidator extends BaseValidator<OrganizationVo> implements Serializable {

	/**
	 *序列化ID 
	 */
	private static final long serialVersionUID = 2254462625894536992L;
	/**
	 * 验证页面输入的信息
	 */
	public void validate(Object target, Errors errors) {
		// 必须输入验证
		ValidationUtils.rejectIfEmpty(errors, "name", "errors.required", new String[] { "名称" });
		
		if (errors.hasErrors()) {
			return;
		}
	}
}
