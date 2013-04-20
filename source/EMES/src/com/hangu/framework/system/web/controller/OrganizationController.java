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
import org.springframework.web.servlet.ModelAndView;

import com.hangu.common.util.DateUtil;
import com.hangu.common.util.StringUtil;
import com.hangu.framework.system.service.OrganizationService;
import com.hangu.framework.system.vo.OrganizationSearchCondition;
import com.hangu.framework.system.vo.OrganizationVo;
import com.hangu.framework.system.web.validate.OrganizationValidator;
import com.hangu.framework.web.controller.EntityController;

@Controller     
@RequestMapping("/system/organization/*")
public class OrganizationController extends EntityController<OrganizationVo, OrganizationSearchCondition> {
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	/**
	 * 转换页面提交来的日期格式
	 */
	@InitBinder
    protected void initBinder1(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtil.getDateTimePattern()), true));
    }

	public OrganizationController() {
		super();
		addValidator = new OrganizationValidator();
		editValidator = addValidator;
		pathPrefix = "system/";
	}
	@Autowired
    public void setOrganizationService(OrganizationService service) {
        setEntityService(service);
    }
	
	@Override
	protected void doRemove(ModelAndView mav, OrganizationVo vo) {
		if (StringUtil.isValidString(vo.getId())) {
			super.doRemove(mav, vo.getId(), vo);
		} else {
			String[] ids = vo.getIds();
			for (int i = 0; (ids != null) && (i < ids.length); i++) {
				super.doRemove(mav, ids[i], vo);
			}
		}
	}
	
	
}
