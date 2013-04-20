package com.hangu.emes.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hangu.emes.dao.DeployManagerDAO;
import com.hangu.emes.entity.DeployManager;
import com.hangu.emes.vo.DeployManagerSearchCondition;
import com.hangu.emes.vo.DeployManagerVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("deployManagerService")
public class DeployManagerServiceImpl extends EntityServiceImpl<DeployManagerVo, DeployManager> implements DeployManagerService {

	@SuppressWarnings("unused")
	private DeployManagerDAO deployManagerDao;
	
	public void setDeployManagerDao(BaseDAO<DeployManager, Serializable> dao) {
		super.setDao(dao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeployManager getDeployManagerByBiz(String biz) {
		DeployManagerSearchCondition condition = new DeployManagerSearchCondition();
		condition.setEnName(biz);
		List<DeployManager> entityList = (List<DeployManager>) search(condition).getResultObject();
		if ((null != entityList) && entityList.size() >= 0) {
			return entityList.get(0);
		}
		return null;
	}
}
