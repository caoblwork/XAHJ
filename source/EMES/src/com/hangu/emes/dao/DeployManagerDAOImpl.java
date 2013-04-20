package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.DeployManager;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "deployManagerDao")
public class DeployManagerDAOImpl extends BaseMyBatisDAOImpl<DeployManager, String> implements DeployManagerDAO {

}
