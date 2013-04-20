package com.hangu.framework.system.web.validate;

import java.io.Serializable;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hangu.common.util.RegexpUtil;
import com.hangu.framework.system.vo.UserVo;
import com.hangu.framework.web.validate.BaseValidator;

public class UserValidator extends BaseValidator<UserVo> implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -3305306361924249201L;

	/**
	 * 对页面输入字段进行验证
	 */
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "organizationId", "errors.required", new String[] { "所属部门" });

		UserVo userVo = (UserVo) target;

		//对页面输入的名称进行验证
		String name = userVo.getName();
		if (name == null) {
			errors.rejectValue("name", "errors.required", new String[] { "用户名称" }, null);
		} else if (!RegexpUtil.isEquals(name, "^[\u4e00-\u9fa5]+$")) {
			errors.rejectValue("name", "errors.invalid", new String[] { "用户名称" }, null);
		}
		//对页面输入的固定电话格式进行验证
		String phone = userVo.getPhone();
		if(phone != null && !RegexpUtil.isEquals(phone, "^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$")){
			errors.rejectValue("phone", "errors.invalid", new String[] { "固定电话" }, null);
		}
		//对页面输入的手机号码格式进行验证
		String mobileNumber = userVo.getMobileNumber();
		if(mobileNumber != null && !RegexpUtil.isEquals(mobileNumber, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$")){
			errors.rejectValue("mobileNumber","errors.invalid",new String[] {"手机号码"}, null);
		}
		//对页面输入的用户账号进行验证
		String account = userVo.getLoginId();
		if (account == null) {
			errors.rejectValue("loginId", "errors.required", new String[] { "用户账号" }, null);
		} else if (!RegexpUtil.isEquals(account, "^[A-Za-z]+$")) {
			errors.rejectValue("loginId", "errors.invalid", new String[] { "用户账号" }, null);
		}
		//对页面输入的用户密码进行验证
		String password = userVo.getPassword();
		if (password == null) {
			errors.rejectValue("password", "errors.required", new String[] { "用户密码" }, null);
		} else if (!RegexpUtil.isEquals(password, "^[A-Za-z0-9]+$")) {
			errors.rejectValue("account", "errors.invalid", new String[] { "用户密码" }, null);
		}

		if (errors.hasErrors()) {
			return;
		}
	}
}
