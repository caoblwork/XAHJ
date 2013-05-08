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
package com.hangu.emes.web.validator;

import org.springframework.validation.Errors;

import com.hangu.emes.entity.CaseInfo;
import com.hangu.emes.vo.CaseInfoVo;
import com.hangu.framework.web.validate.BaseValidator;

/**
 * CaseInfo验证对象
 * 
 * @author 曹保利
 * @version 1.0
 */
public class CaseInfoValidator extends BaseValidator<CaseInfoVo> {
	/** 序列化ID */
	private static final long serialVersionUID = 1760526457337354050L;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.hangutech.smartwork.web.validator.BaseValidator#validate(java.lang
	 * .Object, org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		CaseInfoVo caseInfoVo = (CaseInfoVo) target;
	}
}
