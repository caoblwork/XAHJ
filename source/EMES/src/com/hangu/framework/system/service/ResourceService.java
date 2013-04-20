package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.Resource;
import com.hangu.framework.system.vo.ResourceVo;

public interface ResourceService extends EntityService<ResourceVo, Resource>{

	List<ResourceVo> getResourcesByModelId(String id);

}
