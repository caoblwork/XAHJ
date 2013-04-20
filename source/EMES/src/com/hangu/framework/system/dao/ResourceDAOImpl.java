package com.hangu.framework.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.Resource;

@Repository(value = "resourceDao")
public class ResourceDAOImpl extends BaseMyBatisDAOImpl<Resource, String> implements ResourceDAO {

	@Override
	public List<Resource> findResourcesByModelId(String modelId) {
		String statement = getMapperNamesapce() + ".searchResourcesByModelId";
		return getSqlSessionTemplate().selectList(statement, modelId);
	}

}
