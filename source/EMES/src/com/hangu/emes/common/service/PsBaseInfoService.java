package com.hangu.emes.common.service;

import com.hangu.emes.common.entity.PsBaseInfo;
import com.hangu.emes.common.vo.PsBaseInfoVo;
import com.hangu.framework.service.EntityService;

public interface PsBaseInfoService extends EntityService<PsBaseInfoVo, PsBaseInfo> {
    /**
     * 校验企业名称是否被占用，如果被占用则返回True如果没有被占用则返回false
     * @param vo
     * @return
     */
   // public boolean checkPsName(PsBaseInfoVo vo);

}
