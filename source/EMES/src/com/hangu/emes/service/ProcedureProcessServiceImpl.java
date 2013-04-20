package com.hangu.emes.service;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.common.util.StringUtil;
import com.hangu.emes.common.Constants;
import com.hangu.emes.entity.BaseProcedureEntity;
import com.hangu.emes.vo.BaseProcedureSearchCondition;
import com.hangu.emes.vo.BaseProcedureVo;
import com.hangu.framework.security.SpringSecurityUtils;
import com.hangu.framework.security.UserInfo;
import com.hangu.framework.vo.Page;

@Service("procedureProcessService")
public class ProcedureProcessServiceImpl implements ProcedureProcessService<BaseProcedureVo, BaseProcedureEntity> {

	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private RuntimeService runtimeService;

	//@Override
	public Page searchAndCountTasks(BaseProcedureSearchCondition condition) {
		
		//ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		UserInfo userInfo = SpringSecurityUtils.getCurrentUser();
		
		List<Task> singinTasks = taskService.createTaskQuery().taskCandidateUser(userInfo.getUserId()).list();
		List<Task> handleTasks = taskService.createTaskQuery().taskAssignee(userInfo.getUserId()).list();
		List<Task> tasks = new ArrayList<Task>(singinTasks.size() + handleTasks.size());
		tasks.addAll(singinTasks);
		tasks.addAll(handleTasks);
		// List<Task> tasks = taskService.createTaskQuery().list();

		List<Object> objects = new ArrayList<Object>(tasks.size());
		for (Task task : tasks) {
			BaseProcedureEntity entity = new BaseProcedureEntity();
			entity.setId(task.getId());
			entity.setProcessDefinitionId(task.getProcessDefinitionId());
			entity.setProcessInstanceId(task.getProcessInstanceId());
			if (StringUtil.isValidString(task.getAssignee())) {// 已分配
				entity.setStatus(Constants.TASK_STATUS[1]);
			} else {// 未分配
				entity.setStatus(Constants.TASK_STATUS[0]);
			}
			// 获取全局变量
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			String owner = (String) runtimeService.getVariable(task.getProcessInstanceId(), "owner");
			entity.setProcessLaunchId(owner);
			entity.setProcessId(processInstance.getBusinessKey());

			objects.add(entity);
		}
		long totalCount = taskService.createTaskQuery().count();
		Page page = new Page(condition.getPageNumber().intValue(), condition.getPageSize().intValue(), new Long(totalCount).intValue(), objects);
		return page;
	}

	//@Override
	public Page searchAndCountHistoryTasks(BaseProcedureSearchCondition searchCondition) {

		//ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		UserInfo userInfo = SpringSecurityUtils.getCurrentUser();
		List<HistoricTaskInstance> historyTasks = historyService.createHistoricTaskInstanceQuery().taskAssignee(userInfo.getUserId()).list();

		List<Object> objects = new ArrayList<Object>(historyTasks.size());
		for (HistoricTaskInstance histask : historyTasks) {
			BaseProcedureEntity entity = new BaseProcedureEntity();
			entity.setId(histask.getId());
			entity.setProcessDefinitionId(histask.getProcessDefinitionId());
			entity.setProcessInstanceId(histask.getProcessInstanceId());

			// 获取全局变量
			HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
					.processInstanceId(histask.getProcessInstanceId()).singleResult();
			entity.setProcessLaunchId(historicProcessInstance.getStartUserId());
			entity.setProcessId(historicProcessInstance.getBusinessKey());

			objects.add(entity);
		}

		long totalCount = historyService.createHistoricTaskInstanceQuery().count();
		Page page = new Page(searchCondition.getPageNumber().intValue(), searchCondition.getPageSize().intValue(), new Long(totalCount).intValue(), objects);
		return page;
	}
}
