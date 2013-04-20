package com.hangu.framework.system.dao;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.Organization;

@Repository(value = "organizationDao")
public class OrganizationDAOImpl extends BaseMyBatisDAOImpl<Organization, String> implements OrganizationDAO {

}
