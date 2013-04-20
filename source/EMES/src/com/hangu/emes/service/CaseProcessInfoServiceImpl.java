package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.CaseProcessInfoDAO;
import com.hangu.emes.entity.CaseProcessInfo;
import com.hangu.emes.vo.CaseProcessInfoVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("caseProcessInfoService")
public class CaseProcessInfoServiceImpl extends EntityServiceImpl<CaseProcessInfoVo, CaseProcessInfo> implements CaseProcessInfoService {

	@SuppressWarnings("unused")
	private CaseProcessInfoDAO caseProcessInfoDao;

	@Autowired
	public void setCaseProcessInfoDao(BaseDAO<CaseProcessInfo, Serializable> dao) {
		super.setDao(dao);
	}

}
