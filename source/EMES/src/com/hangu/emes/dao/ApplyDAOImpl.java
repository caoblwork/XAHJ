package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.Apply;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

@Repository(value = "applyDao")
public class ApplyDAOImpl extends BaseMyBatisDAOImpl<Apply, String> implements ApplyDAO {

}
