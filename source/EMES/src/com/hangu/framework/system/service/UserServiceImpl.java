package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.service.LogicProcessResult;
import com.hangu.framework.system.dao.UserDAO;
import com.hangu.framework.system.domain.User;
import com.hangu.framework.system.vo.DataDictionaryVo;
import com.hangu.framework.system.vo.OrganizationVo;
import com.hangu.framework.system.vo.UserSearchCondition;
import com.hangu.framework.system.vo.UserVo;

@Service("userService")
public class UserServiceImpl extends EntityServiceImpl<UserVo, User> implements UserService {

	@Autowired
	private UserDAO userDao;

	public void setUserDao(BaseDAO<User, Serializable> dao) {
		super.dao = dao;
	}

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private DataDictionaryService dataDictionaryService;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVo> getUserByOrganId(String id) {
		UserSearchCondition searchCondition = new UserSearchCondition();
		searchCondition.setOrganizationId(id);

		List<UserVo> userVos = (List<UserVo>) search(searchCondition).getResultObject();
		return userVos;
	}

	@Override
	public LogicProcessResult get(Serializable id) {

		LogicProcessResult logicProcessResult = super.get(id);
		UserVo userVo = (UserVo) logicProcessResult.getResultObject();

		OrganizationVo organizationVo = (OrganizationVo) organizationService.get(userVo.getOrganizationId()).getResultObject();
		if (organizationVo == null) {
			userVo.setOrganizationId(null);
			DataDictionaryVo dictionaryVo = dataDictionaryService.findDataItemsByTypeKey("value", "null");
			userVo.setOrganizationName(dictionaryVo.getValue());
		}else {
			userVo.setOrganizationId(organizationVo.getId());
			userVo.setOrganizationName(organizationVo.getName());
		}
		logicProcessResult.setResultObject(userVo);
		return logicProcessResult;
	}

	@Override
	public UserVo getUserByLoginId(String loginId) {
		UserSearchCondition searchCondition = new UserSearchCondition();
		searchCondition.setLoginId(loginId);
		User entity = userDao.searchUserByLoginId(loginId);
		if (entity != null) {
			String mapID = getEntityName().toLowerCase() + SUFFIX_GET_DETAIL_MAPPING;
			UserVo vo = (UserVo) mapper.map(entity, voClass, mapID);
			return vo;
		}
		return null;
	}

}
