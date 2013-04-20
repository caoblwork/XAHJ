package com.hangu.workflow.dao;

import org.springframework.stereotype.Repository;

import com.hangu.workflow.entity.DeployManager;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "deployManagerDao")
public class DeployManagerDAOImpl extends BaseMyBatisDAOImpl<DeployManager, String> implements DeployManagerDAO {

}
