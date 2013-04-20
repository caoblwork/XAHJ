package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.system.dao.RoleDAO;
import com.hangu.framework.system.domain.Role;
import com.hangu.framework.system.vo.RoleSearchCondition;
import com.hangu.framework.system.vo.RoleVo;

@Service(value = "roleService")
public class RoleServiceImpl extends EntityServiceImpl<RoleVo, Role> implements RoleService {

	@Autowired
	private RoleDAO roleDao;

	// @Autowired
	// private ModelService modelService;

	public void setRoleDao(BaseDAO<Role, Serializable> dao) {
		super.setDao(dao);
	}

	@Override
	public List<RoleVo> getRoleByUserId(String id) {
		List<RoleVo> voList = new ArrayList<RoleVo>();
		List<Role> roleList = (List<Role>) roleDao.findRoleByUserId(id);
		for (Role role : roleList) {
			RoleVo vo = mapper.map(role, voClass);
			voList.add(vo);
		}
		return voList;
	}

}
