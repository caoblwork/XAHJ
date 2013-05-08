package com.hangu.emes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.emes.service.CaseInfoService;
import com.hangu.emes.vo.CaseInfoSearchCondition;
import com.hangu.emes.vo.CaseInfoVo;
import com.hangu.framework.web.controller.EntityController;

/**
 * CaseInfoController对象
 * 
 * @author 曹保利
 * @version 1.0
 */
@Controller
@RequestMapping("/emes/caseInfo/*")
public class CaseInfoController extends EntityController<CaseInfoVo, CaseInfoSearchCondition> {
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(CaseInfoController.class);

	/**
	 * @param service
	 *            the service to set
	 */
	@Autowired
	public void setCaseInfoService(CaseInfoService service) {
		setEntityService(service);
	}

	public CaseInfoController() {
		super();
//		addValidator = new CaseInfoValidator();
//		editValidator = addValidator;
		pathPrefix = "emes/";
	}

}
