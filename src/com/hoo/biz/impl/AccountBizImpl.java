package com.hoo.biz.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;

import com.hoo.biz.AccountBiz;
import com.hoo.dao.AccountDao;
import com.hoo.exception.BizExceptiion;
import com.hoo.mapper.Account;

public class AccountBizImpl<T extends Account> implements AccountBiz<T> {
	
	@Inject
	private AccountDao<T> accountDao;

	public boolean addAccount(T entity) throws DataAccessException {
		if(entity == null)
			throw new BizExceptiion(Account.class.getName()+"is empty!");
		return accountDao.addAccount(entity);
	}

	public T getAccount(Integer id) throws DataAccessException {
		return accountDao.getAccount(id);
	}

	public List<T> getList() throws DataAccessException {
		return accountDao.getList();
	}
}
