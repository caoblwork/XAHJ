package com.hangu.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.SearchCondition;


public interface BaseDAO<T, ID extends Serializable> {

	public T find(ID id);

	public List<T> find(ID... ids);

	public T getReference(ID id);

	public List<T> getReferences(ID... ids);

	public T save(T entity);
	
	public T update(T entity);

	public boolean[] save(T... entities);

	public boolean remove(T entity);

	public void remove(T... entities);

	public boolean removeById(ID id);

	public boolean removeByIds(ID... ids);

	public List<T> findAll();

	public List<T> search(T searchCondition);

	@SuppressWarnings("rawtypes")
	public List<T> search(SearchCondition searchCondition);

	// public SearchResult<T> searchAndCount(String statementName,SearchCondition searchCondition);
	
	/**
	 * 分页查询
	 * 
	 * @param statementName
	 * @param searchCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page pageQuery(String statementName, SearchCondition searchCondition);

	@SuppressWarnings("rawtypes")
	public T searchUnique(SearchCondition searchCondition);

	public JdbcTemplate getJdbcTemplate();


}
