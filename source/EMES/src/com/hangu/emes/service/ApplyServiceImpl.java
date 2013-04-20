package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.ApplyDAO;
import com.hangu.emes.entity.Apply;
import com.hangu.emes.vo.ApplyVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("applyService")
public class ApplyServiceImpl extends EntityServiceImpl<ApplyVo, Apply> implements ApplyService {

	@SuppressWarnings("unused")
	@Autowired
	private ApplyDAO applyDao;

	public void setApplyDao(BaseDAO<Apply, Serializable> dao) {
		super.setDao(dao);
	}
	
}
