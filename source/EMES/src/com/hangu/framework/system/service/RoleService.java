package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.Role;
import com.hangu.framework.system.vo.RoleVo;
import com.hangu.framework.system.vo.UserVo;

public interface RoleService extends EntityService<RoleVo, Role> {

	public List<RoleVo> getRoleByUserId(String id);

	public List<UserVo> getUsersByRolesId(String rolesId);
}
