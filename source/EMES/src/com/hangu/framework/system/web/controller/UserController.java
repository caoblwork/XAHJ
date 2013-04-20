package com.hangu.framework.system.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.hangu.framework.system.domain.User;
import com.hangu.framework.system.service.OrganizationService;
import com.hangu.framework.system.service.UserService;
import com.hangu.framework.system.vo.OrganizationVo;
import com.hangu.framework.system.vo.UserSearchCondition;
import com.hangu.framework.system.vo.UserVo;
import com.hangu.framework.system.web.validate.UserValidator;
import com.hangu.framework.vo.Page;
import com.hangu.framework.web.controller.EntityController;

/**
 * @author 辛 阳
 * 
 */
@Controller
@RequestMapping("/system/user/*")
public class UserController extends EntityController<UserVo, UserSearchCondition> {
	/**
	 * 用户对象
	 */
	private UserController() {
		super();
		addValidator = new UserValidator();
		editValidator = addValidator;
		pathPrefix = "system/";
	}

	/**
	 * 转换页面提交来的日期格式
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtil.getDateTimePattern()), true));
	}

	@Autowired
	private UserService userService;

	@Autowired
	public void setUserService(UserService service) {
		super.setEntityService(service);
	}

	@Autowired
	private OrganizationService organizationService;

	@Override
	protected void decorateSearchResult(Page page) {
		List<Object> object = page.getResult();
		for (Object users : object) {
			User user = (User) users;
			String orgId = user.getOrganizationId();
			if (StringUtil.isValidString(orgId)) {
				OrganizationVo organizationVo = (OrganizationVo) organizationService.get(orgId).getResultObject();
				if(null != organizationVo){
					user.setOrganizationName(organizationVo.getName());
				}
			}
		}
	}

	@Override
	protected void doCreate(ModelAndView mav) {
		super.doCreate(mav);
		UserVo userVo = (UserVo) mav.getModel().get("voModel");
		String orgId = getRequest().getParameter("id");
		if (StringUtil.isValidString(orgId)) {
			UserVo vo = (UserVo) userService.get(orgId).getResultObject();
			String id = vo.getOrganizationId();
			OrganizationVo organizationVo = (OrganizationVo) organizationService.get(id).getResultObject();
			userVo.setOrganizationName(organizationVo.getName());
			userVo.setOrganizationId(organizationVo.getId());
		}
	}

	@Override
	protected void doRemove(ModelAndView mav, UserVo vo) {
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
