package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.system.dao.ResourceDAO;
import com.hangu.framework.system.domain.Resource;
import com.hangu.framework.system.vo.ResourceVo;

@Service(value = "resourceService")
public class ResourceServiceImpl extends EntityServiceImpl<ResourceVo, Resource> implements ResourceService {

	@Autowired
	private ResourceDAO ResourceDao;

	public void setResourceDao(BaseDAO<Resource, Serializable> dao) {
		super.setDao(dao);
	}

	@Override
	public List<ResourceVo> getResourcesByModelId(String id) {
		List<Resource> entitys = ResourceDao.findResourcesByModelId(id);
		List<ResourceVo> voList = new ArrayList<ResourceVo>();
		for (Resource resource : entitys) {
			ResourceVo vo = mapper.map(resource, voClass);
			voList.add(vo);
		}
		return voList;
	}
}
