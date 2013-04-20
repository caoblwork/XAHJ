package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.system.dao.OrganizationDAO;
import com.hangu.framework.system.domain.Organization;
import com.hangu.framework.system.vo.OrganizationSearchCondition;
import com.hangu.framework.system.vo.OrganizationVo;

@Service("organizationService")
public class OrganizationServiceImpl extends EntityServiceImpl<OrganizationVo, Organization> implements OrganizationService {

	@Autowired
	private OrganizationDAO organizationDao;

	public void setOrganizationDao(BaseDAO<Organization, Serializable> dao) {
		super.setDao(dao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationVo> getOrganizationByParentId(String organId) {
		OrganizationSearchCondition organSearchCondition  = new OrganizationSearchCondition();
		organSearchCondition.setParentId(organId);
		List<OrganizationVo> organizationVos = (List<OrganizationVo>)search(organSearchCondition).getResultObject();
		return organizationVos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationVo> getOrganizationById(String id) {
		OrganizationSearchCondition searchCondition = new OrganizationSearchCondition();
		searchCondition.setId(id);
		
		List<OrganizationVo> OrganizationVos = (List<OrganizationVo>) search(searchCondition).getResultObject();
		
		return OrganizationVos;
	}
	

}
