package com.hangu.workflow.listener;

import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import com.hangu.framework.security.SpringContextHolder;


public class TaskAssignListener implements TaskListener {

	RuntimeService runtimeService = (RuntimeService) SpringContextHolder.getApplicationContext().getBean("runtimeService");

	@Override
	public void notify(DelegateTask delegate) {
		String processInstanceId = delegate.getProcessInstanceId();
		Map<String, Object> variablesMap = runtimeService.getVariables(processInstanceId);
		//delegate.createVariablesLocal(variablesMap);
		//delegate.c
	}

}
