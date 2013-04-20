package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.CaseInfoDAO;
import com.hangu.emes.entity.CaseInfo;
import com.hangu.emes.vo.CaseInfoVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("caseInfoService")
public class CaseInfoServiceImpl extends EntityServiceImpl<CaseInfoVo, CaseInfo> implements CaseInfoService {

	@SuppressWarnings("unused")
	private CaseInfoDAO caseInfoDao;

	@Autowired
	public void setCaseInfoDao(BaseDAO<CaseInfo, Serializable> dao) {
		super.setDao(dao);
	}
}
