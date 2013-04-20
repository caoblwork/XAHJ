package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.Model;
import com.hangu.framework.system.vo.ModelVo;

public interface ModelService extends EntityService<ModelVo, Model>{

	List<ModelVo> getModelByRoleId(String id);

}
