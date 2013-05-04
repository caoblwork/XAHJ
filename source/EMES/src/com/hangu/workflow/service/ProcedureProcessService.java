package com.hangu.workflow.service;

import com.hangu.framework.vo.Page;

public interface ProcedureProcessService<BaseProcedureEntity, BaseProcedureSearchCondition> {

	Page searchAndCountTasks(BaseProcedureSearchCondition condition);

	Page searchAndCountHistoryTasks(BaseProcedureSearchCondition searchCondition);

}
