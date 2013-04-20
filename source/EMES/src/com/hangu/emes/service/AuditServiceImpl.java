package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.AuditDAO;
import com.hangu.emes.entity.Audit;
import com.hangu.emes.vo.AuditVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;

@Service("auditService")
public class AuditServiceImpl extends EntityServiceImpl<AuditVo, Audit> implements AuditService {

	@SuppressWarnings("unused")
	@Autowired
	private AuditDAO auditDao;

	public void setAuditDao(BaseDAO<Audit, Serializable> dao) {
		super.setDao(dao);
	}
}
