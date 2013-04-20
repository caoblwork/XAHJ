package com.hangu.framework.system.dao;

import java.util.List;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.system.domain.Resource;

public interface ResourceDAO extends BaseDAO<Resource, String> {
	List<Resource> findResourcesByModelId (String modelId);
}
