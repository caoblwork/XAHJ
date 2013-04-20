package com.hangu.emes.service;

import com.hangu.emes.vo.BaseProcedureSearchCondition;
import com.hangu.framework.vo.Page;

public interface ProcedureProcessService<BaseProcedureVo, BaseProcedureEntity> {

	Page searchAndCountTasks(BaseProcedureSearchCondition condition);

	Page searchAndCountHistoryTasks(BaseProcedureSearchCondition searchCondition);

}
