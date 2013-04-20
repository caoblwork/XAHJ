package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.CaseProcessInfo;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "caseProcessInfoDao")
public class CaseProcessInfoDAOImpl extends BaseMyBatisDAOImpl<CaseProcessInfo, String> implements CaseProcessInfoDAO {

}
