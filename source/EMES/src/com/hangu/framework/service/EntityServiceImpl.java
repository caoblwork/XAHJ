package com.hangu.framework.service;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hangu.common.util.BeanUtils;
import com.hangu.common.util.GenericsUtils;
import com.hangu.common.util.StringUtil;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.dao.domain.BaseEntity;
import com.hangu.framework.mapper.MapperAdapter;
import com.hangu.framework.mapper.ObjectMapper;
import com.hangu.framework.vo.BaseVo;
import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.SearchCondition;

public class EntityServiceImpl<VO extends BaseVo, Entity extends BaseEntity> extends BaseServiceImpl implements EntityService<VO, Entity> {

	/**
	 * 日志对象
	 */
	protected static Logger logger = LoggerFactory.getLogger(EntityServiceImpl.class);

	protected BaseDAO<Entity, Serializable> dao = null;

	protected Class<VO> voClass = null;

	protected Class<Entity> entityClass = null;

	protected ObjectMapper mapper = null;

	/**
	 * 缺省构造函数
	 * <p>
	 * 初始化VO class类型;初始化Entity class类型;
	 * 
	 */
	@SuppressWarnings("unchecked")
	public EntityServiceImpl() {
		super();
		mapper = new MapperAdapter();
		voClass = GenericsUtils.getGenericClass(getClass());
		entityClass = GenericsUtils.getGenericClass(getClass(), 1);
	}

	/**
	 * 设置DAO
	 */
	public void setDao(BaseDAO<Entity, Serializable> dao) {
		this.dao = dao;
	}

	/**
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 获取Entity的名称
	 * 
	 * @return Entity名称
	 */
	protected String getEntityName() {
		return entityClass.getSimpleName();
	}

	@Transactional(readOnly = true)
	public LogicProcessResult get(Serializable id) {
		LogicProcessResult logicProcessResult = new LogicProcessResult();
		Entity entity = dao.find(id);
		if (entity != null) {
			String mapID = getEntityName().toLowerCase() + SUFFIX_GET_DETAIL_MAPPING;
			logicProcessResult.setResultObject((VO) mapper.map(entity, voClass, mapID));
		}
		return logicProcessResult;
	}

	@Transactional(readOnly = true)
	public LogicProcessResult get(Serializable... ids) {
		LogicProcessResult logicProcessResult = new LogicProcessResult();
		List<Entity> entityList = dao.find(ids);
		List<VO> voList = new ArrayList<VO>(entityList.size());
		String mapID = getEntityName().toLowerCase() + SUFFIX_GET_DETAIL_MAPPING;
		for (Entity entity : entityList) {
			voList.add((VO) mapper.map(entity, voClass, mapID));
		}
		logicProcessResult.setResultObject(voList);
		return logicProcessResult;
	}

	@Transactional(readOnly = true)
	public LogicProcessResult getAll() {
		LogicProcessResult logicProcessResult = new LogicProcessResult();
		List<Entity> entityList = dao.findAll();
		List<VO> voList = new ArrayList<VO>(entityList.size());
		String mapID = getEntityName().toLowerCase() + SUFFIX_GET_DETAIL_MAPPING;
		for (Entity entity : entityList) {
			voList.add((VO) mapper.map(entity, voClass, mapID));
		}
		logicProcessResult.setResultObject(voList);
		return logicProcessResult;
	}

	@Transactional(readOnly = true)
	public Page searchAndCount(SearchCondition searchCondition) {
		return dao.pageQuery("selectPage", searchCondition);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public LogicProcessResult remove(Serializable id) {
		return new LogicProcessResult(dao.removeById(id));
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public LogicProcessResult remove(Serializable... ids) {
		dao.removeByIds(ids);
		return new LogicProcessResult();

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public LogicProcessResult remove(VO valueObject) {
		String mapID = getEntityName().toLowerCase() + SUFFIX_REMOVE_MAPPING;
		Entity entity = (Entity) mapper.map(valueObject, entityClass, mapID);
		return new LogicProcessResult(dao.remove(entity));
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	public LogicProcessResult remove(VO... valueObjects) {
		Entity[] entitys = (Entity[]) Array.newInstance(entityClass, valueObjects.length);
		String mapID = getEntityName().toLowerCase() + SUFFIX_REMOVE_MAPPING;
		for (int i = 0; i < valueObjects.length; i++) {
			entitys[i] = (Entity) mapper.map(valueObjects[i], entityClass, mapID);
		}
		dao.remove(entitys);
		return new LogicProcessResult();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public LogicProcessResult save(VO valueObject) {
		Entity entity = null;
		if (StringUtil.isValidString(valueObject.getId())) {
			// 从数据库上获取要更新的业务Entity
			Entity tmpEntity = (Entity) dao.find(valueObject.getId());
			if (null != tmpEntity) {
				entity = prepare4Update(valueObject);
				entity = dao.update(entity);
			} else {
				String mapID = getEntityName().toLowerCase() + SUFFIX_CREATE_MAPPING;
				entity = (Entity) mapper.map(valueObject, entityClass, mapID);
				entity = dao.save(entity);
			}
		} else {
			String mapID = getEntityName().toLowerCase() + SUFFIX_CREATE_MAPPING;
			entity = (Entity) mapper.map(valueObject, entityClass, mapID);
			entity = dao.save(entity);
		}
		return new LogicProcessResult(entity == null ? Boolean.FALSE : Boolean.TRUE);
	}

	/**
	 * 更新用Entity数据转配
	 * 
	 * @param valueObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Entity prepare4Update(VO valueObject) {
		// 从数据库上获取要更新的业务Entity
		Entity tmpEntity = (Entity) dao.find(valueObject.getId());
		// 获取业务Entity中所有类型为BaseEntity的属性
		List<Field> entityFields = BeanUtils.getFieldsByType(tmpEntity, BaseEntity.class);
		// 对检索到的业务Entity创建副本
		Entity entity = (Entity) BeanUtils.deepClone(tmpEntity);
		Map<String, Object> fieldNames = new HashMap<String, Object>();
		for (Field entityField : entityFields) {
			BaseEntity holdEntity = (BaseEntity) BeanUtils.getProperty(entity, entityField.getName());
			// 避免含有同类型的Entity且相同时出现的值传递问题、故对类型相同的第二个属性进行克隆
			if (holdEntity != null && fieldNames.containsKey(entityField.getType().getName())) {
				holdEntity = (BaseEntity) BeanUtils.deepClone(holdEntity);
			} else {
				// 对于首次出现的直接添加到Map中，以备后续检查
				fieldNames.put(entityField.getType().getName(), entityField);
			}
			if (holdEntity != null) {
				BeanUtils.setProperty(entity, entityField.getName(), holdEntity);
			}
		}
		// 乐观锁判断对象是否存在版本冲突，如果存在就抛出异常
		if (entity.getVersion() != null && valueObject.getVersion() != null) {
			if (entity.getVersion().compareTo(valueObject.getVersion()) != 0) {
				throw new OptimisticLockingFailureException("");
			}
		}
		String mapID = getEntityName().toLowerCase() + SUFFIX_UPDATE_MAPPING;
		mapper.map(valueObject, entity, mapID);
		return entity;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public LogicProcessResult save(VO... valueObjects) {
		for (int i = 0; i < valueObjects.length; i++) {
			save(valueObjects[i]);
		}
		return new LogicProcessResult();
	}

	@Transactional(readOnly = true)
	public LogicProcessResult search(SearchCondition searchCondition) {
		long startTime = System.currentTimeMillis();
		List<Entity> entityList = dao.search(searchCondition);
		logger.debug("search Using Time :" + (System.currentTimeMillis() - startTime));
		List<VO> voList = new ArrayList<VO>(entityList.size());
		String mapID = getEntityName().toLowerCase() + SUFFIX_SEARCH_MAPPING;
		for (Entity entity : entityList) {
			voList.add((VO) mapper.map(entity, voClass, mapID));
		}
		logger.debug("search Using Time :" + (System.currentTimeMillis() - startTime));
		return new LogicProcessResult(voList);
	}

	@Transactional(readOnly = true)
	public LogicProcessResult searchUnique(SearchCondition searchCondition) {
		LogicProcessResult logicProcessResult = new LogicProcessResult();
		Entity entity = dao.searchUnique(searchCondition);
		if (entity == null) {
			return logicProcessResult;
		}
		String mapID = getEntityName().toLowerCase() + SUFFIX_SEARCH_UNIQUE_MAPPING;
		logicProcessResult.setResultObject((VO) mapper.map(entity, voClass, mapID));
		return logicProcessResult;
	}

}
