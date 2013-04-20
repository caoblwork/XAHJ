package com.hangu.framework.system.dao;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.User;

/**
 * 
 * @author 辛 阳
 * 
 */
@Repository("userDao")
public class UserDAOImpl extends BaseMyBatisDAOImpl<User, String> implements UserDAO {

	@Override
	public User searchUserByLoginId(String loginId) {
		String statement = getMapperNamesapce() + ".searchUserByLoginId";
		return sqlSessionTemplate.selectOne(statement, loginId);
	}
}
