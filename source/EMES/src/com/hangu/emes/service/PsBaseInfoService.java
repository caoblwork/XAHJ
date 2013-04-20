package com.hangu.emes.service;

import com.hangu.emes.entity.PsBaseInfo;
import com.hangu.emes.vo.PsBaseInfoVo;
import com.hangu.framework.service.EntityService;

public interface PsBaseInfoService extends EntityService<PsBaseInfoVo, PsBaseInfo> {
    /**
     * 校验企业名称是否被占用，如果被占用则返回True如果没有被占用则返回false
     * @param vo
     * @return
     */
   // public boolean checkPsName(PsBaseInfoVo vo);

}
