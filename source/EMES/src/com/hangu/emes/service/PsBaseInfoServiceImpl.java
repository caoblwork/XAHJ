package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.PsBaseInfoDAO;
import com.hangu.emes.entity.PsBaseInfo;
import com.hangu.emes.vo.PsBaseInfoVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service(value = "psBaseInfoService")
public class PsBaseInfoServiceImpl extends EntityServiceImpl<PsBaseInfoVo, PsBaseInfo> implements PsBaseInfoService {
    
	@SuppressWarnings("unused")
	@Autowired
	private PsBaseInfoDAO psBaseInfoDao;

	public void setPsBaseInfoDao(BaseDAO<PsBaseInfo, Serializable> psBaseInfoDao) {
		super.dao = psBaseInfoDao;
	}
}
