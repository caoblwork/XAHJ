package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.system.dao.DataDictionaryDAO;
import com.hangu.framework.system.domain.DataDictionary;
import com.hangu.framework.system.vo.DataDictionarySearchCondition;
import com.hangu.framework.system.vo.DataDictionaryVo;

@Service(value = "dataDictionaryService")
public class DataDictionaryServiceImpl extends EntityServiceImpl<DataDictionaryVo, DataDictionary> implements DataDictionaryService {

	@SuppressWarnings("unused")
	@Autowired
	private DataDictionaryDAO dataDictionaryDao;

	public void setDataDictionaryDao(BaseDAO<DataDictionary, Serializable> dao) {
		super.setDao(dao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataDictionaryVo> findDataItemsByType(String type) {
		DataDictionarySearchCondition dataDictionarySearchCondition = new DataDictionarySearchCondition();
		dataDictionarySearchCondition.setType(type);
		List<DataDictionaryVo> dataDictVoList = (List<DataDictionaryVo>) search(dataDictionarySearchCondition).getResultObject();
		return dataDictVoList;
	}

	@Override
	public DataDictionaryVo findDataItemsByTypeKey(String dataType, String dataKey) {
		DataDictionarySearchCondition dataDictionarySearchCondition = new DataDictionarySearchCondition();
		dataDictionarySearchCondition.setType(dataType);
		dataDictionarySearchCondition.setKey(dataKey);
		DataDictionaryVo vo = (DataDictionaryVo) searchUnique(dataDictionarySearchCondition).getResultObject();
		return vo;
	}
}
