package com.hangu.framework.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.Role;

@Repository(value = "roleDao")
public class RoleDAOImpl extends BaseMyBatisDAOImpl<Role, String> implements RoleDAO {

	@Override
	public List<Role> findRoleByUserId(String userId) {
		String statement = getMapperNamesapce() + ".searchRoleByUserId";
		return getSqlSessionTemplate().selectList(statement, userId);
	}

}
