package com.hangu.framework.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hangu.common.util.GenericsUtils;
import com.hangu.common.util.StringUtil;
import com.hangu.framework.service.EntityService;
import com.hangu.framework.vo.BaseVo;
import com.hangu.framework.vo.SearchCondition;
import com.hangu.framework.web.validate.BaseValidator;

/**
 * 单业务对象Controller的基类
 * 
 * @author 曹保利
 * 
 * @param <VO>
 * @param <SC>
 * @param <PO>
 */
public abstract class AbstractEntityController<VO extends BaseVo, SC extends SearchCondition> extends BaseController {

	/**
	 * 服务对象
	 */
	@SuppressWarnings("rawtypes")
	protected EntityService entityService = null;

	/**
	 * 表现层值对象类
	 */
	protected Class<VO> voClass = null;

	/**
	 * 新建输入验证器
	 */
	protected Validator addValidator = new BaseValidator<BaseVo>();

	/**
	 * 编辑修改验证器
	 */
	protected Validator editValidator = new BaseValidator<BaseVo>();

	/**
	 * 查询输入验证器
	 */
	protected Validator searchValidator = new BaseValidator<BaseVo>();

	/**
	 * doList方法是否有效，Ajax调用时设置此属性为false减少一次查询<br>
	 * 设置为false后list方法只是进行页面迁移不调用后台服务器检索数据
	 */
	protected boolean doListEnable = true;

	@SuppressWarnings("unchecked")
	public AbstractEntityController() {
		super();
		voClass = GenericsUtils.getGenericClass(getClass());
		if (viewNameMap == null) {
			viewNameMap = new HashMap<String, String>();
		}
		viewNameMap.put("indexView", "/index");
		viewNameMap.put("listView", "/list");
		viewNameMap.put("addView", "/add");
		viewNameMap.put("editView", "/edit");
		viewNameMap.put("showView", "/show");
	}

	/**
	 * @param service
	 *            the service to set
	 */
	@SuppressWarnings("rawtypes")
	public void setEntityService(EntityService service) {
		this.entityService = service;
	}

	/**
	 * 获取Entity的名称
	 * 
	 * @return Entity名称
	 */
	protected String getEntityName() {
		// 获取VO名称 如：XXXVo
		String entityClassNameStr = voClass.getSimpleName();
		// //获取Entity名称 如：XXXVo去除后面的Vo
		entityClassNameStr = entityClassNameStr.substring(0, entityClassNameStr.length() - 2);
		entityClassNameStr = StringUtils.substring(entityClassNameStr, 0, 1).toLowerCase() + StringUtils.substring(entityClassNameStr, 1);
		return entityClassNameStr;
	}

	/**
	 * 获取Entity的名称
	 * 
	 * @return Entity名称
	 */
	protected void setViewNameMap(Map<String, String> viewNameMap) {
		this.viewNameMap = viewNameMap;
	}

	/**
	 * 默认Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index() {
		logger.debug("beging process index.do");
		String viewName = pathPrefix + getEntityName() + viewNameMap.get("indexView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		doIndex(mav);
		logger.debug("end process index.do");
		return mav;
	}

	protected abstract void doIndex(ModelAndView mav);

	/**
	 * 列表Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(SC searchCondition, BindingResult bindingResult) {
		logger.debug("beging process list.do");
		String viewName = pathPrefix + getEntityName() + viewNameMap.get("listView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		searchValidator.validate(searchCondition, bindingResult);
		if (bindingResult.hasErrors()) {
			prepareListData(mav);
			logger.error(bindingResult.getAllErrors().toString());
		} else {
			doList(mav, searchCondition);
		}
		logger.debug("end process list.do");
		return mav;
	}

	/**
	 * 
	 * @param mav
	 */
	protected abstract void prepareListData(ModelAndView mav);

	/**
	 * 
	 * @param mav
	 * @param searchCondition
	 */
	protected abstract void doList(ModelAndView mav, SC searchCondition);

	/**
	 * 创建Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "add.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView create() {
		logger.debug("beging process add.do");
		String viewName = pathPrefix + getEntityName() + viewNameMap.get("addView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		doCreate(mav);
		logger.debug("end process add.do");
		return mav;
	}

	protected abstract void doCreate(ModelAndView mav);

	/**
	 * 保存Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("voModel") VO vo, BindingResult bindingResult) {
		logger.debug("beging process save.do");
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("list.do"));
		if (StringUtil.isValidString(vo.getId())) {
			editValidator.validate(vo, bindingResult);
			if (bindingResult.hasErrors()) {
				prepareEditData(mav, vo.getId());
				String viewName = pathPrefix + getEntityName() + viewNameMap.get("editView");
				logger.debug("viewName=" + viewName);
				mav.setViewName(viewName);
				return mav;
			}
		} else {
			addValidator.validate(vo, bindingResult);
			if (bindingResult.hasErrors()) {
				prepareAddData(mav);
				mav.setViewName(pathPrefix + getEntityName() + viewNameMap.get("addView"));
				logger.debug("viewName=" + mav.getViewName());
			}
		}
		if (!bindingResult.hasErrors()) {
			doSave(mav, vo, bindingResult);
		}
		logger.debug("end process save.do");
		return mav;
	}

	protected abstract void doSave(ModelAndView mav, VO vo, BindingResult bindingResult);

	protected abstract void prepareAddData(ModelAndView mav);

	protected abstract void prepareEditData(ModelAndView mav, String id);

	/**
	 * 显示Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "show.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView show(String id) {
		logger.debug("beging process show.do");
		String viewName = pathPrefix + getEntityName() + viewNameMap.get("showView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		doShow(mav, id);
		logger.debug("end process show.do");
		return mav;
	}

	protected abstract void doShow(ModelAndView mav, String id);

	/**
	 * 编辑Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "edit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView edit(String id) {
		logger.debug("beging process edit.do");
		String viewName = pathPrefix + getEntityName() + viewNameMap.get("editView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		doEdit(mav, id);
		logger.debug("end process edit.do");
		return mav;
	}

	protected abstract void doEdit(ModelAndView mav, String id);

	/**
	 * 删除Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "remove.do", method = RequestMethod.POST)
	public ModelAndView remove(@ModelAttribute("voModel") VO vo) {
		logger.debug("beging process remove.do");
		logger.debug("remove condition =" + vo.toString());
		ModelAndView mav = new ModelAndView(new RedirectView("list.do"));
		doRemove(mav, vo);
		logger.debug("end process remove.do");
		return mav;
	}

	protected abstract void doRemove(ModelAndView mav, VO vo);

	/**
	 * 删除Action处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "remove.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView remove(String id, BaseVo vo) {
		logger.debug("beging process remove.do");
		logger.debug("remove id =" + id);
		logger.debug("remove condition =" + vo.toString());
		ModelAndView mav = new ModelAndView(new RedirectView("list.do"));
		doRemove(mav, id, vo);
		logger.debug("end process remove.do");
		return mav;
	}

	protected abstract void doRemove(ModelAndView mav, String id, BaseVo vo);
}
