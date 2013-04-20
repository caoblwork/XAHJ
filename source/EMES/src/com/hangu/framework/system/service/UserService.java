package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.User;
import com.hangu.framework.system.vo.UserVo;

public interface UserService extends EntityService<UserVo, User> {
	
	List<UserVo> getUserByOrganId(String id);

	UserVo getUserByLoginId(String loginId);
}
