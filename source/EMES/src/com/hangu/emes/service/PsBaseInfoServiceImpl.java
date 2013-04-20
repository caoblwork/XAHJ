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
    
	@Autowired
	private PsBaseInfoDAO psBaseInfoDao;

	public void setPsBaseInfoDao(BaseDAO<PsBaseInfo, Serializable> psBaseInfoDao) {
		super.dao = psBaseInfoDao;
	}
    

//    @SuppressWarnings("unchecked")
//    @Override
//    public boolean checkPsName(PsBaseInfoVo vo) {
//        Search search = new Search();
//        search.addFilterEqual("psname", vo.getPsname());
//        List<PsBaseInfoVo> voList = (List<PsBaseInfoVo>) search(search).getResultObject();
//        if (voList.size() > 0) {
//            return Boolean.TRUE;
//        } else {
//            return Boolean.FALSE;
//        }
//    }
}
