/*
 * Copyright 2005-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hangu.emes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.emes.service.WrydaxxService;
import com.hangu.emes.vo.WrydaxxSearchCondition;
import com.hangu.emes.vo.WrydaxxVo;
import com.hangu.framework.web.controller.EntityController;

/**
 * 企业长期存档Controller
 * 
 * @author 
 * @version 1.0
 */
@Controller
@RequestMapping("/emes/wrydaxx/*")
public class WrydaxxController extends EntityController<WrydaxxVo, WrydaxxSearchCondition> {
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(WrydaxxController.class);
    /**
     * @param service the service to set
     */
    @Autowired
    public void setWrydaxxService(WrydaxxService service) {
        setEntityService(service);
    }
    
    public WrydaxxController() {
        super();
//        addValidator = new WrydaxxValidator();
//        editValidator = addValidator;
        pathPrefix = "emes/";
    }
}
