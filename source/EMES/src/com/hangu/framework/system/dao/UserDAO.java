package com.hangu.framework.system.dao;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.system.domain.User;

public interface UserDAO extends BaseDAO<User, String>{

	User searchUserByLoginId(String loginId);
	
}
