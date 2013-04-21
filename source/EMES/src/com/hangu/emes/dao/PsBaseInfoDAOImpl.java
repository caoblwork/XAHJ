package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.PsBaseInfo;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;

/**
 * 企业信息接口实现类
 * @author hupeng
 *
 */
@Repository(value = "psBaseInfoDao")
public class PsBaseInfoDAOImpl extends BaseMyBatisDAOImpl<PsBaseInfo,String> implements PsBaseInfoDAO {

}
