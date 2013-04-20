package com.hangu.framework.system.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
import com.hangu.framework.system.dao.ModelDAO;
import com.hangu.framework.system.domain.Model;
import com.hangu.framework.system.vo.ModelVo;

@Service(value = "modelService")
public class ModelServiceImpl extends EntityServiceImpl<ModelVo, Model> implements ModelService {

	@Autowired
	private ModelDAO modelDao;

	public void setModelDao(BaseDAO<Model, Serializable> dao) {
		super.setDao(dao);
	}

	@Override
	public List<ModelVo> getModelByRoleId(String id) {
		List<Model> entitys = modelDao.findModelByRoleId(id);
		List<ModelVo> voList = new ArrayList<ModelVo>();
		for (Model model : entitys) {
			ModelVo vo = mapper.map(model, voClass);
			voList.add(vo);
		}
		return voList;
	}

}
