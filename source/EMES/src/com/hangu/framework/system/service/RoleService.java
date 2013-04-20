package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.Role;
import com.hangu.framework.system.vo.RoleVo;

public interface RoleService extends EntityService<RoleVo, Role>{

	List<RoleVo> getRoleByUserId(String id);

}
