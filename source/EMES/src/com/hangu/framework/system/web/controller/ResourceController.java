package com.hangu.framework.system.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.common.util.DateUtil;
import com.hangu.framework.system.service.ResourceService;
import com.hangu.framework.system.vo.ResourceSearchCondition;
import com.hangu.framework.system.vo.ResourceVo;
import com.hangu.framework.system.web.validate.ResourceValidator;
import com.hangu.framework.web.controller.EntityController;

@Controller
@RequestMapping("/system/resource/*")
public class ResourceController extends EntityController<ResourceVo, ResourceSearchCondition>{
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(ResourceController.class);
	/**
	 * 转换页面提交来的日期格式
	 */
	@InitBinder
    protected void initBinder1(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtil.getDateTimePattern()), true));
    }

	public ResourceController() {
		super();
		addValidator = new ResourceValidator();
		editValidator = addValidator;
		pathPrefix = "system/";
	}
	
	@Autowired
    public void setResourceService(ResourceService service) {
        setEntityService(service);
    }
}
