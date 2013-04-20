package com.hangu.emes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.emes.service.SupervisoryTaskService;
import com.hangu.emes.vo.SupervisoryTaskSearchCondition;
import com.hangu.emes.vo.SupervisoryTaskVo;
import com.hangu.framework.web.controller.EntityController;

@Controller
@RequestMapping("/eme/supervisoryTask/*")
public class SupervisoryTaskController extends EntityController<SupervisoryTaskVo, SupervisoryTaskSearchCondition> {

	@SuppressWarnings("unused")
	@Autowired
	private void setSupervisoryTaskService(SupervisoryTaskService supervisoryTaskService) {
		this.setEntityService(supervisoryTaskService);
	}

	public SupervisoryTaskController() {
		super();
		pathPrefix = "eme/";
	}

}
