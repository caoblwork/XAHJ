package com.hangu.framework.system.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hangu.common.util.StringUtil;
import com.hangu.framework.system.service.DataDictionaryService;
import com.hangu.framework.system.vo.DataDictionarySearchCondition;
import com.hangu.framework.system.vo.DataDictionaryVo;
import com.hangu.framework.system.web.validate.DataDictionaryValidator;
import com.hangu.framework.web.controller.EntityController;

@Controller
@RequestMapping("/system/dataDictionary/*")
public class DataDictionaryController extends EntityController<DataDictionaryVo, DataDictionarySearchCondition> {
	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(DataDictionaryController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	public DataDictionaryController() {
		super();
		addValidator = new DataDictionaryValidator();
		editValidator = addValidator;
		pathPrefix = "system/";
	}

	@Autowired
	public void setDataDictionaryService(DataDictionaryService service) {
		setEntityService(service);
	}

	@Override
	protected void doRemove(ModelAndView mav, DataDictionaryVo vo) {
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
