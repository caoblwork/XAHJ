package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.hangu.emes.dao.SupervisoryTaskDAO;
import com.hangu.emes.entity.SupervisoryTask;
import com.hangu.emes.vo.SupervisoryTaskVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("supervisoryTaskService")
public class SupervisoryTaskServiceImpl extends EntityServiceImpl<SupervisoryTaskVo, SupervisoryTask> {
	
	@SuppressWarnings("unused")
	private SupervisoryTaskDAO supervisoryTaskDao;
	
	public void setSupervisoryTaskDao(BaseDAO<SupervisoryTask, Serializable> dao) {
		super.setDao(dao);
	}
}
