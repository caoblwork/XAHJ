package com.hangu.framework.service;

import java.io.Serializable;

import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.dao.domain.BaseEntity;
import com.hangu.framework.vo.BaseVo;
import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.SearchCondition;

/**
 * 
 * @author 曹保利
 * 
 * @param <T>
 */
public interface EntityService<VO extends BaseVo, Entity extends BaseEntity> extends BaseService {

    public static final String SUFFIX_GET_DETAIL_MAPPING = "GetDetailMapping";

    public static final String SUFFIX_REMOVE_MAPPING = "RemoveMapping";

    public static final String SUFFIX_UPDATE_MAPPING = "UpdateMapping";

    public static final String SUFFIX_CREATE_MAPPING = "CreateMapping";

    public static final String SUFFIX_SEARCH_MAPPING = "SearchMapping";

    public static final String SUFFIX_SEARCH_UNIQUE_MAPPING = "SearchUniqueMapping";
    
    /**
     * 
     * @param dao
     */
    public void setDao(BaseDAO<Entity, Serializable> dao);

    /**
     * 保存业务Entity
     * 
     * @param entity 业务Entity
     * @return
     */
    public LogicProcessResult save(VO valueObject);

    /**
     * 
     * @param o
     * @return
     */
    public LogicProcessResult save(VO... valueObjects);
    
    /**
     * 
     * @param id
     * @return
     */
    public LogicProcessResult remove(Serializable id);

    /**
     * 
     * @param ids
     */
    public LogicProcessResult remove(Serializable... ids);

    /**
     * 
     * @param entity
     * @return
     */
    public LogicProcessResult remove(VO valueObject);

    /**
     * 
     * @param entities
     */
    public LogicProcessResult remove(VO... valueObjects);

    /**
     * 根据主键获取对象
     * 
     * @param id
     * @return 表示对象
     */
    public LogicProcessResult get(Serializable id);

    /**
     * 
     * @param ids
     * @return
     */
    public LogicProcessResult get(Serializable... ids);

    /**
     * 获取所有对象
     * 
     * @return 表示对象集
     */
    public LogicProcessResult getAll();

    /**
     * 
     * @param search
     * @return
     */
    public LogicProcessResult search(SearchCondition searchCondition);

    public Page searchAndCount(SearchCondition searchCondition);
    //public LogicProcessResult searchAndCount(SearchCondition searchCondition);

    /**
     * 
     * @param search
     * @return
     */
    public LogicProcessResult searchUnique(SearchCondition searchCondition);
}
