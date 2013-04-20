package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.Organization;
import com.hangu.framework.system.vo.OrganizationVo;

public interface OrganizationService extends EntityService<OrganizationVo, Organization>{
	/**
	 * 根据parentID的值加载组织机构
	 * @param organId
	 * @return
	 */
	public List<OrganizationVo> getOrganizationByParentId(String organId);

	public List<OrganizationVo> getOrganizationById(String id);

}
