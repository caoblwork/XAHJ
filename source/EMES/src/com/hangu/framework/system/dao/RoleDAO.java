package com.hangu.framework.system.dao;

import java.util.List;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.system.domain.Role;

public interface RoleDAO extends BaseDAO<Role, String>{

	List<Role> findRoleByUserId(String userId);

}
