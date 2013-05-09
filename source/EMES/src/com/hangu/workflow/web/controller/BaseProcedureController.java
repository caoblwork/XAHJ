package com.hangu.workflow.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.web.controller.BaseController;
import com.hangu.workflow.service.DeployManagerService;
import com.hangu.workflow.service.ProcedureProcessService;

@SuppressWarnings("rawtypes")
public abstract class BaseProcedureController extends BaseController {

	protected EntityService entityService = null;

	@Autowired
	private ProcedureProcessService procedureProcessService;

	@Autowired
	private DeployManagerService deployManagerService;

	/**
	 * 创建业务流程的开始申请
	 * 
	 * @param biz
	 *            业务名称(也就是deploy的enName)
	 * @return
	 */
	@RequestMapping(value = "{biz}/create.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView create(@PathVariable("biz") String biz) {
		logger.debug("beging process " + biz + "create.do");
		String viewName = findViewByFormKey(biz);
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);

		// doCreate(biz, mav);

		logger.debug("end process add.do");
		return mav;
	}

	/**
	 * 从对应关系中找见该biz所代表的流程的create结点绑定的对象与表单关系
	 * 
	 * @param biz
	 * @return
	 */
	protected abstract String findViewByFormKey(String biz);
}
