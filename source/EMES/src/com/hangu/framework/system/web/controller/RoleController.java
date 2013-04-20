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
import com.hangu.framework.system.service.RoleService;
import com.hangu.framework.system.vo.RoleSearchCondition;
import com.hangu.framework.system.vo.RoleVo;
import com.hangu.framework.system.web.validate.RoleValidator;
import com.hangu.framework.web.controller.EntityController;

@Controller
@RequestMapping("/system/role/*")
public class RoleController extends EntityController<RoleVo, RoleSearchCondition>{
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(RoleController.class);
	/**
	 * 转换页面提交来的日期格式
	 */
	@InitBinder
    protected void initBinder1(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtil.getDateTimePattern()), true));
    }

	public RoleController() {
		super();
		addValidator = new RoleValidator();
		editValidator = addValidator;
		pathPrefix = "system/";
	}
	
	@Autowired
    public void setRoleService(RoleService service) {
        setEntityService(service);
    }
}
