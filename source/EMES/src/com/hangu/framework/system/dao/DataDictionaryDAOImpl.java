package com.hangu.framework.system.dao;

import org.springframework.stereotype.Repository;

import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;
import com.hangu.framework.system.domain.DataDictionary;

@Repository(value = "dataDictionaryDao")
public class DataDictionaryDAOImpl extends BaseMyBatisDAOImpl<DataDictionary, String> implements DataDictionaryDAO {

}
