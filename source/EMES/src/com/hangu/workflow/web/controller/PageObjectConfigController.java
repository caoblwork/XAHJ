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
package com.hangu.workflow.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.framework.web.controller.EntityController;
import com.hangu.workflow.service.PageObjectConfigService;
import com.hangu.workflow.vo.PageObjectConfigSearchCondition;
import com.hangu.workflow.vo.PageObjectConfigVo;
import com.hangu.workflow.web.validator.PageObjectConfigValidator;

/**
 * PageObjectConfigController对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
@Controller
@RequestMapping("/workflow/pageObjectConfig/*")
public class PageObjectConfigController extends EntityController<PageObjectConfigVo, PageObjectConfigSearchCondition> {
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(PageObjectConfigController.class);

	/**
	 * @param service
	 *            the service to set
	 */
	@Autowired
	public void setPageObjectConfigService(PageObjectConfigService service) {
		setEntityService(service);
	}

	public PageObjectConfigController() {
		super();
		addValidator = new PageObjectConfigValidator();
		editValidator = addValidator;
		pathPrefix = "workflow/";
	}
}
