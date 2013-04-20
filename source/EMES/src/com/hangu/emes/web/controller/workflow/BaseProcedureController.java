package com.hangu.emes.web.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hangu.common.util.StringUtil;
import com.hangu.emes.entity.BaseProcedureEntity;
import com.hangu.emes.service.ProcedureProcessService;
import com.hangu.emes.vo.BaseProcedureSearchCondition;
import com.hangu.framework.security.SpringSecurityUtils;
import com.hangu.framework.security.UserInfo;
import com.hangu.framework.service.EntityService;
import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.SearchCondition;
import com.hangu.framework.web.controller.BaseController;

public abstract class BaseProcedureController extends BaseController {

	@Autowired
	protected FormService formService;

	@Autowired
	protected TaskService taskService;

	@Autowired
	protected HistoryService historyService;

	@Autowired
	protected RuntimeService runtimeService;

	@Autowired
	protected IdentityService identityService;

	@Autowired
	protected RepositoryService repositoryService;

	protected String entityName = null;

	@SuppressWarnings("rawtypes")
	protected EntityService entityService = null;

	@SuppressWarnings("rawtypes")
	@Autowired
	private ProcedureProcessService procedureProcessService;

	public BaseProcedureController() {

		super();

		viewNameMap.put("createView", "/create");
		viewNameMap.put("handleView", "/handle");
		viewNameMap.put("modifyView", "/modify");

		viewNameMap.put("taskListView", "/taskList");
		viewNameMap.put("historyTaskListView", "/historyTaskList");

		viewNameMap.put("procedureInfoView", "/popupProcedureInfo");

		viewNameMap.put("errorView", "/error");
		viewNameMap.put("listView", "/list");
		viewNameMap.put("showView", "/show");
	}

	/**
	 * 创建业务流程的开始申请
	 * 
	 * @param biz
	 *            业务名称(也就是deploy的enName)
	 * @return
	 */
	@RequestMapping(value = "{biz}/create.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView create(@PathVariable("biz") String biz) {
		logger.debug("beging process add.do");
		String viewName = pathPrefix + biz + viewNameMap.get("createView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);

		doCreate(biz, mav);

		logger.debug("end process add.do");
		return mav;
	}

	/**
	 * 历史业务列表
	 * 
	 * @param biz
	 * @param searchCondition
	 * @return
	 */
	@RequestMapping(value = "{biz}/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(@PathVariable("biz") String biz, SearchCondition searchCondition) {
		logger.debug("beging process list.do");
		String viewName = pathPrefix + biz + viewNameMap.get("listView");
		logger.debug("viewName=" + viewName);

		ModelAndView mav = new ModelAndView(viewName);
		BaseProcedureSearchCondition procedureSearchCondition = new BaseProcedureSearchCondition();
		mav.addObject("searchCondition", procedureSearchCondition);

		doList(biz, mav);

		Page page = (Page) entityService.searchAndCount(procedureSearchCondition);
		mav.addObject("totalRecords", page.getTotalCount());
		mav.addObject("records", page.getResult());
		mav.addObject("pageObject", page);

		logger.debug("end process list.do");
		return mav;
	}

	/**
	 * 该业务（流程）中的待办任务
	 * 
	 * @param biz
	 * @param searchCondition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "{biz}/taskList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView taskList(@PathVariable("biz") String biz, BaseProcedureSearchCondition searchCondition) {
		logger.debug("begin process taskList.do!");
		String viewName = pathPrefix + biz + viewNameMap.get("taskListView");
		logger.debug("viewName=" + viewName);

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("searchCondition", searchCondition);

		Page page = procedureProcessService.searchAndCountTasks(searchCondition);

		mav.addObject("totalRecords", page.getTotalCount());
		mav.addObject("records", page.getResult());
		mav.addObject("pageObject", page);

		logger.debug("end process taskList.do!");
		return mav;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "{biz}/historyTaskList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView historyTaskList(@PathVariable("biz") String biz, BaseProcedureSearchCondition searchCondition) {
		logger.debug("begin process historyTaskList.do!");
		String viewName = pathPrefix + biz + viewNameMap.get("historyTaskListView");
		logger.debug("viewName=" + viewName);

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("searchCondition", searchCondition);

		Page page = procedureProcessService.searchAndCountHistoryTasks(searchCondition);

		mav.addObject("totalRecords", page.getTotalCount());
		mav.addObject("records", page.getResult());
		mav.addObject("pageObject", page);

		logger.debug("end process historyTaskList.do!");
		return mav;
	}

	/**
	 * 所有业务中的待办任务
	 * 
	 * @param searchCondition
	 * @return
	 */
	@RequestMapping(value = "taskList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView taskList(SearchCondition searchCondition) {
		logger.debug("begin process taskList.do!");
		// TODO 后续处理
		logger.debug("end process taskList.do!");
		return null;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "{biz}/process.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView process(@PathVariable("biz") String biz, @ModelAttribute("voModel") BaseProcedureEntity entity, BindingResult bindingResult,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		logger.debug("beging process process.do");
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("list.do"));

		Enumeration<String> enumeration = request.getParameterNames();
		Map<String, String> beanMap = new HashMap<String, String>();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String val = request.getParameter(key);
			beanMap.put(key, val);
		}

		doProcess(biz, mav, beanMap);

		logger.debug("end process process.do");
		return mav;
	}

	@RequestMapping(value = "{biz}/signin/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView signin(@PathVariable("biz") String biz, @PathVariable("id") String id, RedirectAttributes redirectAttributes) {

		String path = getRequest().getContextPath() + "/" + pathPrefix + biz;
		ModelAndView mav = new ModelAndView(new RedirectView(path + "/taskList.do"));

		// ShiroUser shiroUser = (ShiroUser)
		// SecurityUtils.getSubject().getPrincipal();
		UserInfo userInfo = SpringSecurityUtils.getCurrentUser();
		taskService.claim(id, userInfo.getUserId());
		return mav;
	}

	/**
	 * 
	 * @param biz
	 * @param taskId
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "{biz}/handle/{taskId}", method = { RequestMethod.GET, RequestMethod.POST }, params = { "view" })
	public ModelAndView handle(@PathVariable("biz") String biz, @PathVariable("taskId") String taskId, @RequestParam("view") String view,
			RedirectAttributes redirectAttributes) {
		logger.debug("beging process add.do");
		String viewName = pathPrefix + biz + "/" + view;// viewNameMap.get("handleView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);

		doHandle(biz, taskId, mav);

		logger.debug("end process add.do");
		return mav;
	}

	/**
	 * 
	 * @param biz
	 * @param taskId
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "{biz}/handle/{taskId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView handle(@PathVariable("biz") String biz, @PathVariable("taskId") String taskId, RedirectAttributes redirectAttributes) {
		logger.debug("beging process add.do");
		String viewName = pathPrefix + biz + viewNameMap.get("handleView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);

		doHandle(biz, taskId, mav);

		logger.debug("end process add.do");
		return mav;
	}

	@RequestMapping(value = "{biz}/modify/{taskId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView modify(@PathVariable("biz") String biz, @PathVariable("taskId") String taskId, RedirectAttributes redirectAttributes) {
		logger.debug("beging process modify");
		String viewName = pathPrefix + biz + viewNameMap.get("modifyView");
		logger.debug("viewName=" + viewName);
		ModelAndView mav = new ModelAndView(viewName);

		doModify(biz, taskId, mav);

		logger.debug("end process modify");
		return mav;
	}

	/**
	 * 转向流程图信息查看页面
	 * 
	 * @param biz
	 * @param processInstanceId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "{biz}/viewProcedureInfo/{processInstanceId}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView procedureInfo(@PathVariable("biz") String biz, @PathVariable("processInstanceId") String processInstanceId,
			RedirectAttributes redirectAttributes) {

		logger.debug("beging process viewProcedureInfo");
		String viewName = pathPrefix + viewNameMap.get("procedureInfoView");
		logger.debug("viewName=" + viewName);

		ModelAndView mav = new ModelAndView(viewName);
		List<ActivityImpl> activities = new ArrayList<ActivityImpl>();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId())
				.singleResult();

		ProcessDefinitionImpl processDefinitionImpl = (ProcessDefinitionImpl) processDefinition;
		String processDefinitionId = processDefinitionImpl.getId();// 流程标识
		ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(processDefinitionId);

		List<ActivityImpl> activitiList = def.getActivities();// 获得当前任务的所有节点
		List<String> ActiveActivityIds = runtimeService.getActiveActivityIds(processInstanceId);// 获取将被执行的活动节点
		for (String activeId : ActiveActivityIds) {
			for (ActivityImpl activityImpl : activitiList) {
				String id = activityImpl.getId();
				if (activityImpl.isScope()) {// 判断节点是否为subProcess
					if (activityImpl.getActivities().size() > 1) {
						List<ActivityImpl> subAcList = activityImpl.getActivities();
						for (ActivityImpl subActImpl : subAcList) {
							String subid = subActImpl.getId();
							if (activeId.equals(subid)) {// 获得执行到的活动节点
								activities.add(subActImpl);
								break;
							}
						}
					}

				}
				if (activeId.equals(id)) {// 获得执行到的活动节点
					activities.add(activityImpl);
				}
			}
		}

		mav.addObject("activities", activities);
		mav.addObject("processInstanceId", processInstanceId);
		logger.debug("end    process viewProcedureInfo");
		return mav;
	}

	/**
	 * 输出对应流程定义资源中的流程描述图片
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping(value = "{biz}/resourceInfo/{processInstanceId}", method = { RequestMethod.GET, RequestMethod.POST })
	public void resourceInfo(@PathVariable("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse response) {

		logger.debug("beging process checkProcessImg.do");

		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId())
				.singleResult();
		InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());

		byte[] bytes = new byte[1024 * 4];
		int size = 0;
		try {

			ServletOutputStream outputStream = response.getOutputStream();
			response.setContentType("image/png");
			while ((size = inputStream.read(bytes, 0, 1024 * 4)) != -1) {
				outputStream.write(bytes, 0, size);
			}

			outputStream.flush();
			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
			logger.error("查看流程图片失败.", e);
		}
		logger.debug("end process wfUpload.do");
	}

	@RequestMapping(value = "{biz}/resourceInfoX/{processInstanceId}", method = { RequestMethod.GET, RequestMethod.POST })
	public void resourceInfoX(@PathVariable("processInstanceId") String processInstanceId, HttpServletRequest request, HttpServletResponse response) {

		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

		List<Execution> executionList = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).list();
		List<String> highLightList = new ArrayList<String>();
		for (Execution ex : executionList) {
			// 执行实例，execId为当前正在执行的实体ID
			ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(ex.getId()).singleResult();
			// 当前实例的执行到哪个节点
			String activitiId = execution.getActivityId();
			// 将节点存到高亮显示的集合中
			highLightList.add(activitiId);
		}

		ProcessDefinitionEntity pde = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(processInstance
				.getProcessDefinitionId());
		InputStream inputStream = ProcessDiagramGenerator.generateDiagram(pde, "png", highLightList);

		byte[] bytes = new byte[1024 * 4];
		int size = 0;
		try {

			ServletOutputStream outputStream = response.getOutputStream();
			response.setContentType("image/png");
			while ((size = inputStream.read(bytes, 0, 1024 * 4)) != -1) {
				outputStream.write(bytes, 0, size);
			}

			outputStream.flush();
			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
			logger.error("查看流程图片失败.", e);
		}
		logger.debug("end process wfUpload.do");
	}

	protected abstract void doCreate(String biz, ModelAndView mav);

	protected abstract void doList(String biz, ModelAndView mav);

	protected abstract void doProcess(String biz, ModelAndView mav, Map<String, String> beanMap);

	protected abstract void doHandle(String biz, String taskId, ModelAndView mav);

	protected abstract void doModify(String biz, String taskId, ModelAndView mav);

	/**
	 * 提供提取实体类名称的工具方法
	 * 
	 * @param className
	 *            "包名.类名"
	 * @return 实体名称
	 */
	public static String getEntityName(String className) {

		String entityName = null;
		char[] charArray;

		if (!StringUtil.isValidString(className)) {
			return entityName;
		} else if (className.contains(".")) {
			entityName = className.substring(className.lastIndexOf(".") + 1, className.length());
			charArray = entityName.toCharArray();
		} else {
			charArray = className.toCharArray();
		}

		charArray[0] = Character.toLowerCase(charArray[0]);
		entityName = String.copyValueOf(charArray);

		return entityName;
	}

	/**
	 * 获取entity的名称（格式：类名且首字母小写，不包括包名）
	 * 
	 * @param entityName
	 * @return 类名且首字母小写的entity名称
	 */
	protected String getEntityServiceName(String entityName) {
		return entityName + "Service";
	}

}
