package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.SupervisoryTask;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "deployManagerDao")
public class SupervisoryTaskDAOImpl extends BaseMyBatisDAOImpl<SupervisoryTask, String> implements SupervisoryTaskDAO {

}
