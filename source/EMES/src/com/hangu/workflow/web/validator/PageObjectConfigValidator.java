/*
 * Copyright 2005-2010 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.hangu.workflow.web.validator;

import org.springframework.validation.Errors;

import com.hangu.framework.web.validate.BaseValidator;
import com.hangu.workflow.entity.PageObjectConfig;
import com.hangu.workflow.vo.PageObjectConfigVo;

/**
 * PageObjectConfig验证对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public class PageObjectConfigValidator extends BaseValidator<PageObjectConfigVo> {
	/** 序列化ID */
	private static final long serialVersionUID = 6160044079197255975L;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.hangutech.smartwork.web.validator.BaseValidator#validate(java.lang
	 * .Object, org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		PageObjectConfigVo pageObjectConfigVo = (PageObjectConfigVo) target;
	}
}
