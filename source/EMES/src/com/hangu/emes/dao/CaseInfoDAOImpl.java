package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.CaseInfo;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "caseInfoDao")
public class CaseInfoDAOImpl extends BaseMyBatisDAOImpl<CaseInfo, String> implements CaseInfoDAO {

}
