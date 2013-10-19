package com.hoo.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;

import com.hoo.dao.AccountDao;
import com.hoo.mapper.Account;
import com.hoo.mapper.AccountMapper;

@SuppressWarnings("unchecked")
public class AccountDaoImpl<T extends Account> implements AccountDao<T> {
	@Inject
	private AccountMapper mapper;

	public boolean addAccount(T entity) throws DataAccessException {
		boolean flag = false;
		try {
			mapper.addAccount(entity);
			flag = true;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public T getAccount(Integer id) throws DataAccessException {
		T entity = null;
		try {
			entity = (T) mapper.getAccoutnById(String.valueOf(id));
		} catch (DataAccessException e) {
			throw e;
		}
		return entity;
	}

	public List<T> getList() throws DataAccessException {
		return (List<T>) mapper.getAllAccount();
	}

}
