package com.hangu.emes.service;

import com.hangu.emes.entity.DeployManager;
import com.hangu.emes.vo.DeployManagerVo;
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
