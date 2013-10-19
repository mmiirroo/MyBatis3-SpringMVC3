package com.hoo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hoo.mapper.SqlMapper;

public interface BaseSqlMapper<T> extends SqlMapper {
	public void add(T entity) throws DataAccessException;
	
	public void edit(T entity) throws DataAccessException;

	public void remove(T entity) throws DataAccessException;

	public T get(T entity) throws DataAccessException;

	public List<T> getList(T entity) throws DataAccessException;
}
