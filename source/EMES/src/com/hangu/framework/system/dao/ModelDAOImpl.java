package com.hangu.framework.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.Model;

@Repository(value = "modelDao")
public class ModelDAOImpl extends BaseMyBatisDAOImpl<Model, String> implements ModelDAO {

	@Override
	public List<Model> findModelByRoleId(String roleId) {
		String statement = getMapperNamesapce() + ".searchModelByRoleId";
		return getSqlSessionTemplate().selectList(statement, roleId);
	}

}
