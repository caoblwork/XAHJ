package com.hangu.workflow.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hangu.common.util.StringUtil;
import com.hangu.emes.common.ProcedureProcessAction;
import com.hangu.framework.security.SpringContextHolder;
import com.hangu.framework.security.SpringSecurityUtils;
import com.hangu.framework.security.UserInfo;
import com.hangu.framework.service.EntityService;
import com.hangu.workflow.entity.BaseProcedureEntity;
import com.hangu.workflow.entity.DeployManager;
import com.hangu.workflow.service.DeployManagerService;
import com.hangu.workflow.vo.BaseProcedureVo;

@Controller
@RequestMapping("/workflow/*")
public class ProcedureProcessController extends BaseProcedureController {

	@Autowired
	private DeployManagerService deployManagerService;

	private ProcessDefinition processDefinition = null;

	public ProcedureProcessController() {
		super();
		pathPrefix = "workflow/";
	}

	@Override
	protected void doCreate(String biz, ModelAndView mav) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		String className = getDynamicClassName(biz, null, deployManager, ProcedureProcessAction.create);
		super.entityName = getEntityName(className);
		BaseProcedureEntity entity = (BaseProcedureEntity) SpringContextHolder.getApplicationContext().getBean(entityName);
		entity.setProcessDeployId(deployManager.getDeployId());
		mav.addObject("voModel", entity);
	}

	@Override
	protected void doHandle(String biz, String taskId, ModelAndView mav) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		String className = getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.approval);
		super.entityName = getEntityName(className);
		BaseProcedureEntity entity = (BaseProcedureEntity) SpringContextHolder.getApplicationContext().getBean(entityName);
		entity.setTaskId(taskId);
		entity.setProcessDeployId(deployManager.getDeployId());
		String action = (String) mav.getModel().get("action");
		entity.setAction(action);
		mav.addObject("voModel", entity);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doModify(String biz, String taskId, ModelAndView mav) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		String className = getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.modify);
		super.entityName = getEntityName(className);

		// 根据taskId获取historyTask
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		String owner = (String) runtimeService.getVariable(task.getProcessInstanceId(), "owner");
		super.entityService = (EntityService) SpringContextHolder.getApplicationContext().getBean(getEntityServiceName(entityName));
		BaseProcedureEntity entity = (BaseProcedureEntity) entityService.get(processInstance.getBusinessKey()).getResultObject();
		entity.setTaskId(taskId);
		entity.setProcessLaunchId(owner);

		entity.setProcessDeployId(deployManager.getDeployId());
		mav.addObject("voModel", entity);
	}

	private void doProcessComplete(String biz, ModelAndView mav, Map<String, String> beanMap) {
		// TODO 完成一般的task的complete动作
		String taskId = beanMap.get("taskId");
		// 将form参数或者url参数的数据装入流程变量里面
		Map<String, Object> variables = new HashMap<String, Object>();
		Set<String> keySet = beanMap.keySet();
		for (String key : keySet) {
			variables.put(key, beanMap.get(key));
		}
		taskService.complete(taskId, variables);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doList(String biz, ModelAndView mav) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		super.entityName = getEntityName(getDynamicClassName(biz, null, deployManager, ProcedureProcessAction.create));
		super.entityService = (EntityService) SpringContextHolder.getApplicationContext().getBean(getEntityServiceName(entityName));
	}

	@Override
	protected void doProcess(String biz, ModelAndView mav, Map<String, String> beanMap) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployManager.getDeployId()).singleResult();

		String action = beanMap.get("action");
		if (ProcedureProcessAction.create.name().equals(action)) {
			doProcessCreate(biz, mav, beanMap);
		} else if (ProcedureProcessAction.approval.name().equals(action)) {
			doProcessApproval(biz, mav, beanMap);
		} else if (ProcedureProcessAction.modify.name().equals(action)) {
			doProcessModify(biz, mav, beanMap);
			// doProcessApproval(biz, mav, beanMap);
		} else if (ProcedureProcessAction.complete.name().equals(action)) {
			doProcessComplete(biz, mav, beanMap);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void doProcessModify(String biz, ModelAndView mav, Map<String, String> beanMap) {

		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		// 1.获取taskId
		String taskId = beanMap.get("taskId");
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		// 2.组装对应的实体类
		try {
			String beanName = (String) beanMap.get("beanName");
			Object obj = null;
			if (StringUtil.isValidString(beanName)) {
				obj = SpringContextHolder.getBean(beanName);
			} else {
				String className = getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.approval);
				super.entityName = getEntityName(getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.approval));
				super.entityService = (EntityService) SpringContextHolder.getApplicationContext().getBean(getEntityServiceName(entityName));
				obj = Class.forName(className).newInstance();
			}
			beanMap.put("processDeployId", deployManager.getDeployId());
			BeanUtils.populate(obj, beanMap);
			BaseProcedureVo entity = (BaseProcedureVo) obj;
			entity.setProcessDefinitionId(processDefinition.getId());
			entity.setProcessDeployId(deployManager.getDeployId());
			String owner = (String) runtimeService.getVariable(task.getProcessInstanceId(), "owner");
			entity.setProcessInstanceId(task.getProcessInstanceId());
			entity.setProcessLaunchId(owner);
			if (!StringUtil.isValidString(entity.getId())) {
				BaseProcedureVo entity2 = (BaseProcedureVo) entityService.get(processInstance.getBusinessKey()).getResultObject();
				entity.setId(processInstance.getBusinessKey());
				entity.setProcessId(entity.getId());
				com.hangu.common.util.BeanUtils.beanShallowCopy(entity2, entity);
				entityService.save(entity2);
			} else {
				entityService.save(entity);
			}

			// 3.处理任务结点
			Map<String, Object> variables = new HashMap<String, Object>();
			Set<String> keySet = beanMap.keySet();
			for (String key : keySet) {
				variables.put(key, beanMap.get(key));
			}
			taskService.complete(taskId, variables);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void doProcessCreate(String biz, ModelAndView mav, Map<String, String> beanMap) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		// 1.获取该结点的class & form
		String className = getDynamicClassName(biz, null, deployManager, ProcedureProcessAction.create);
		super.entityName = getEntityName(getDynamicClassName(biz, null, deployManager, ProcedureProcessAction.create));
		super.entityService = (EntityService) SpringContextHolder.getApplicationContext().getBean(getEntityServiceName(entityName));
		// ShiroUser shiroUser = (ShiroUser)
		// SecurityUtils.getSubject().getPrincipal();
		UserInfo userInfo = SpringSecurityUtils.getCurrentUser();

		try {
			// 1.组装bean
			Object obj = Class.forName(className).newInstance();
			beanMap.put("processLaunchId", userInfo.getUserId());
			beanMap.put("processDeployId", deployManager.getDeployId());
			BeanUtils.populate(obj, beanMap);
			BaseProcedureVo entity = (BaseProcedureVo) obj;
			entity.setProcessDefinitionId(processDefinition.getId());
			entity.setProcessDeployId(deployManager.getDeployId());

			// 2.业务存储标志
			String bizKey = UUID.randomUUID().toString().replace("-", "");

			// 3.驱动流程
			ProcessInstance processInstance = null;
			try {
				identityService.setAuthenticatedUserId(userInfo.getUserId());
				// 在启动流程时将BusinessKey附加起来很方便取值 && 并且将initrator设置owner直接可以去到发起人id
				processInstance = runtimeService.startProcessInstanceById(entity.getProcessDefinitionId(), bizKey);
				// 4.更新业务变量
				entity.setId(bizKey);
				entity.setProcessInstanceId(processInstance.getId());
				entityService.save(entity);

			} finally {
				identityService.setAuthenticatedUserId(null);
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void doProcessApproval(String biz, ModelAndView mav, Map<String, String> beanMap) {
		DeployManager deployManager = deployManagerService.getDeployManagerByBiz(biz);
		// 1.获取taskId
		String taskId = beanMap.get("taskId");
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
		// 2.获取该结点的class & form
		String className = getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.approval);
		super.entityName = getEntityName(getDynamicClassName(biz, taskId, deployManager, ProcedureProcessAction.approval));
		super.entityService = (EntityService) SpringContextHolder.getApplicationContext().getBean(getEntityServiceName(entityName));

		try {
			// 1.组装bean
			Object obj = Class.forName(className).newInstance();
			beanMap.put("processDeployId", deployManager.getDeployId());
			BeanUtils.populate(obj, beanMap);
			BaseProcedureVo entity = (BaseProcedureVo) obj;
			entity.setProcessDefinitionId(processDefinition.getId());
			entity.setProcessDeployId(deployManager.getDeployId());
			// 2.获取申请业务id
			String owner = (String) runtimeService.getVariable(task.getProcessInstanceId(), "owner");
			entity.setProcessId(processInstance.getBusinessKey());
			entity.setProcessInstanceId(task.getProcessInstanceId());
			entity.setProcessLaunchId(owner);
			entityService.save(entity);
			// 3.处理任务结点
			Map<String, Object> variables = new HashMap<String, Object>();
			Set<String> keySet = beanMap.keySet();
			for (String key : keySet) {
				variables.put(key, beanMap.get(key));
			}
			// variables.put("decision", beanMap.get("decision"));
			taskService.complete(taskId, variables);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private String getDynamicClassName(String biz, String taskId, DeployManager deployManager, ProcedureProcessAction action) {

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployManager.getDeployId()).singleResult();
		String className = null;
		switch (action) {
			case create:
				if (processDefinition.hasStartFormKey()) {// start结点绑定业务表单，处理表单
					className = formService.getStartFormData(processDefinition.getId()).getFormKey();
				} else {// start结点没有绑定业务表单
					//
				}
				return className;

			case approval:
				if (processDefinition.hasStartFormKey()) {// start结点绑定业务表单，处理表单
					className = formService.getTaskFormData(taskId).getFormKey();
				} else {// start结点没有绑定业务表单
					//
				}
				return className;

			case modify:
				if (processDefinition.hasStartFormKey()) {// start结点绑定业务表单，处理表单
					className = formService.getTaskFormData(taskId).getFormKey();
				} else {// start结点没有绑定业务表单
					//
				}
				return className;

			case end:
				break;
		}
		return className;
	}
}
