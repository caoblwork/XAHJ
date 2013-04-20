package com.hangu.framework.system.dao;

import java.util.List;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.system.domain.Model;

public interface ModelDAO extends BaseDAO<Model, String> {

	List<Model> findModelByRoleId(String roleId);

}
