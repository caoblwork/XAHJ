package com.hangu.framework.web.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hangu.common.util.GenericsUtils;
import com.hangu.framework.vo.BaseVo;

public class BaseValidator<Vo extends BaseVo> extends ExtendValidator implements Validator {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 8695726932758342307L;

    public boolean supports(Class<?> candidate) {
        Class<?> validateTargetClass = GenericsUtils.getGenericClass(BaseValidator.class);
        return validateTargetClass.isAssignableFrom(candidate);
    }

    /**
     * 验证逻辑处理
     * 
     * @param target 被验证对象
     * @param errors 验证结果
     */
    public void validate(Object target, Errors errors) {
        // DO NOTHING
    }

}
