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
package com.hangu.emes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.emes.service.SupervisoryTaskService;
import com.hangu.emes.vo.SupervisoryTaskSearchCondition;
import com.hangu.emes.vo.SupervisoryTaskVo;
import com.hangu.emes.web.validator.SupervisoryTaskValidator;
import com.hangu.framework.web.controller.EntityController;

/**
 * SupervisoryTaskController对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
@Controller
@RequestMapping("/emes/supervisoryTask/*")
public class SupervisoryTaskController extends EntityController<SupervisoryTaskVo, SupervisoryTaskSearchCondition> {
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(SupervisoryTaskController.class);

	/**
	 * @param service
	 *            the service to set
	 */
	@Autowired
	public void setSupervisoryTaskService(SupervisoryTaskService service) {
		setEntityService(service);
	}

	public SupervisoryTaskController() {
		super();
		addValidator = new SupervisoryTaskValidator();
		editValidator = addValidator;
		pathPrefix = "emes/";
	}
}
