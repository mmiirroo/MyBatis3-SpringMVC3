package com.hoo.mapper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration("classpath:applicationContext-*.xml")
public class AccountMapperTest extends AbstractJUnit38SpringContextTests {
	@Inject
	private AccountMapper mapper;
	
	public void testGetAccount(){
		System.out.println(mapper.getAccoutn());
	}
	
	public void testGetAccountById(){
		System.out.println(mapper.getAccoutnById("28"));
	}
	
    public void testGetAccountByName() {
        System.out.println(mapper.getAccountByName("user"));
    }
    
    public void testAdd() {
        Account account = new Account();
        account.setEmail("temp@155.com");
        account.setPassword("abc");
        account.setRoleId(1);
        account.setSalt("ss");
        account.setStatus(0);
        account.setUsername("Jack");
        mapper.addAccount(account);
    }
    
    public void testEditAccount() {
        Account acc = mapper.getAccountByName("Jack");
        System.out.println(acc);
        acc.setUsername("Zhangsan");
        acc.setPassword("123123");
        mapper.editAccount(acc);
        System.out.println(mapper.getAccoutnById(acc.getAccountId() + ""));
    }

    

    public void testRemoveAccount() {
        Account acc = mapper.getAccountByName("Jack");
        mapper.removeAccount(acc.getAccountId());
        System.out.println(mapper.getAccountByName("Jack"));
    }

    

    public void testAccountList() {
        List<Account> acc = mapper.getAllAccount();
        System.out.println(acc.size());
        System.out.println(acc);
    }
}
