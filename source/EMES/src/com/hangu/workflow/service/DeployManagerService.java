package com.hangu.workflow.service;

import com.hangu.workflow.entity.DeployManager;
import com.hangu.workflow.vo.DeployManagerVo;
import com.hangu.framework.service.EntityService;

public interface DeployManagerService extends EntityService<DeployManagerVo, DeployManager> {
	/**
	 * 根据业务匹配流程的部署环境
	 * 
	 * @param biz
	 *            业务编码也就是DeployManager的enName
	 * @return 部署管理对象
	 */
	public DeployManager getDeployManagerByBiz(String biz);

}
