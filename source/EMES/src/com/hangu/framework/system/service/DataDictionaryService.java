package com.hangu.framework.system.service;

import java.util.List;

import com.hangu.framework.service.EntityService;
import com.hangu.framework.system.domain.DataDictionary;
import com.hangu.framework.system.vo.DataDictionaryVo;

public interface DataDictionaryService extends EntityService<DataDictionaryVo, DataDictionary> {
	/**
	 * 根据数据字典的type查询所有的数据字典对象集合
	 */
	List<DataDictionaryVo> findDataItemsByType(String type);

	/**
	 * 根据数据字典的type来查询唯一的数据字典对象
	 * 
	 * @param dataType
	 * @param dataKey
	 * @return
	 */
	DataDictionaryVo findDataItemsByTypeKey(String dataType, String dataKey);

}
