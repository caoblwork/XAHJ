package com.hangu.workflow.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.workflow.dao.DeployManagerDAO;
import com.hangu.workflow.entity.DeployManager;
import com.hangu.workflow.vo.DeployManagerSearchCondition;
import com.hangu.workflow.vo.DeployManagerVo;

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
