package com.hoo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AccountMapper extends SqlMapper {
	public List<Account> getAllAccount();
	
	public Account getAccoutn();
	
	public Account getAccoutnById(String id);
	
	@Select("select * from where username = #{name}")
	public Account getAccountByName(String name);
	
	public void addAccount(Account account);
	
	public void editAccount(Account accoutn);
	
	public void removeAccount(int id);
}
