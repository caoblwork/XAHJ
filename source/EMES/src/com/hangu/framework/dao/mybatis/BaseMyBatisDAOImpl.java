package com.hangu.framework.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hangu.common.util.GenericsUtils;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.dao.IdGenerator;
import com.hangu.framework.dao.domain.BaseEntity;
import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.SearchCondition;

@SuppressWarnings("rawtypes")
public class BaseMyBatisDAOImpl<T extends BaseEntity, ID extends Serializable> implements BaseDAO<T, ID> {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 数据操作访问模板对象
	 */
	@Autowired(required = false)
	protected SqlSessionTemplate sqlSessionTemplate = null;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	public String getMapperNamesapce() {
		StringBuilder mapperNamesapce = new StringBuilder();
		mapperNamesapce.append(getClass().getPackage().getName());
		mapperNamesapce.append(".mapper.");
		Class<?> entityClass = GenericsUtils.getSuperClassGenricType(getClass());
		mapperNamesapce.append(entityClass.getSimpleName());
		mapperNamesapce.append("Mapper");
		return mapperNamesapce.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(ID id) {
		Object object = getSqlSessionTemplate().selectOne(getFindByIdStatement(), id);
		return (T) object;
	}

	@Override
	public List<T> find(ID... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getReference(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getReferences(ID... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T entity) {
		if (StringUtils.isBlank(entity.getId())) {
			entity.setId(IdGenerator.generateUUID());
		}
		int rowNumber = getSqlSessionTemplate().insert(getInsertStatement(), entity);
		return rowNumber >= 0 ? entity : null;
	}

	@Override
	public boolean[] save(T... entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T entity) {
		int rowNumber = getSqlSessionTemplate().update(getUpdateStatement(), entity);
		return rowNumber >= 0 ? entity : null;
	}

	@Override
	public boolean remove(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(T... entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean removeById(ID id) {
		int rowNum = getSqlSessionTemplate().delete(getDeleteStatement(), id);
		return rowNum > 0;
	}

	@Override
	public boolean removeByIds(ID... ids) {
		int rowNum = getSqlSessionTemplate().delete(getDeleteByIdsStatement(), ids);
		return rowNum > 0;
	}

	@Override
	public List<T> findAll() {
		return sqlSessionTemplate.selectList(getGetAllStatement());
	}

	@Override
	public List<T> search(T searchCondition) {
		String tmpStatementName = getMapperNamesapce() + ".search";
		return sqlSessionTemplate.selectList(tmpStatementName, searchCondition);
	}

	@Override
	public List<T> search(SearchCondition searchCondition) {
		String tmpStatementName = getMapperNamesapce() + ".search";
		return sqlSessionTemplate.selectList(tmpStatementName, searchCondition);
	}

	@Override
	public Page pageQuery(String statementName, SearchCondition searchCondition) {
		String tmpStatementName = getMapperNamesapce() + "." + statementName;
		return pageQuery(tmpStatementName, getPagingCountStatement(tmpStatementName), searchCondition);
	}

	@SuppressWarnings("unchecked")
	public Page pageQuery(String statementName, String countStatementName, SearchCondition searchCondition) {
		Number totalCount = (Number) sqlSessionTemplate.selectOne(countStatementName, searchCondition);
		if (totalCount == null || totalCount.longValue() <= 0) {
			return new Page(searchCondition, 0);
		}
		Page page = new Page(searchCondition, totalCount.intValue());
		RowBounds bounds = new RowBounds(page.getFirstResult(), page.getPageSize());
		List list = sqlSessionTemplate.selectList(statementName, searchCondition, bounds);
		page.setResult(list);
		return page;
	}

	@Override
	public T searchUnique(SearchCondition searchCondition) {
		return sqlSessionTemplate.selectOne("searchUnique", searchCondition);
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFindByIdStatement() {
		return getMapperNamesapce() + ".getById";
	}

	public String getGetAllStatement() {
		return getMapperNamesapce() + ".getAll";
	}

	public String getInsertStatement() {
		return getMapperNamesapce() + ".insert";
	}

	public String getUpdateStatement() {
		return getMapperNamesapce() + ".update";
	}

	public String getDeleteStatement() {
		return getMapperNamesapce() + ".delete";
	}

	public String getDeleteByIdsStatement() {
		return getMapperNamesapce() + ".deleteByIds";
	}

	private String getPagingCountStatement(String statementName) {
		return statementName + "Count";
	}
}
