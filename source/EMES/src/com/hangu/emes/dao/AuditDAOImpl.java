package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.Audit;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "auditDao")
public class AuditDAOImpl extends BaseMyBatisDAOImpl<Audit, String> implements AuditDAO {

}
