package com.hoo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({ "unchecked", "unused" })
public class BaseDaoImpl<T extends Object> extends SqlSessionDaoSupport
		implements BaseDao<T> {

	@Inject
	private SqlSessionFactory sqlSessionFactory;

	public boolean add(String classMethod, T entity) throws Exception {
		boolean flag = false;
		try {
			flag = this.getSqlSession().insert(classMethod, entity) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public boolean edit(String classMethod, T entity) throws Exception {
		boolean flag = false;
		try {
			flag = this.getSqlSession().update(classMethod, entity) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public T get(String classMethod, T entity) throws Exception {
		T result = null;
		try {
			result = (T) this.getSqlSession().selectOne(classMethod, entity);
		} catch (Exception e) {
			throw e;
		}
		// TODO Auto-generated method stub
		return result;
	}

	public List<T> getAll(String classMethod, T entity) throws Exception {
		List<T> result = new ArrayList<T>();
		try {
			result = this.getSqlSession().selectList(classMethod);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public boolean remove(String classMethod, T entity) throws Exception {
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(classMethod, entity) > 0 ? true
					: false;
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}
}
