package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.User;


public class BeanConfig {
	
	@Bean(name="account")
	@Primary
	public Account getAccount() {
		Account ret= new Account();
		return ret;
	}
	
	@Bean(name="account1")
	@Scope("prototype")
	public Account getAccount1() {
		Account ret= new Account();
		return ret;
	}
	
	@Bean(name="account2")
	public Account getAccount2() {		
		return  Account.getInstance();
	}
	
	@Bean(name="account3")
	public Account getAccount3() {
		return  Account.getInstance();
	}
	
	int count;
	@Bean(name="account4")
	@Scope("prototype")
	//@Scope(ConfigurableFactory.SCOPE_PROTOTYPE)
	public Account getAccount4() {
		return count++<3 ? new Account() : Account.getInstance();
	}
	
	@Bean(name="myUser")
	public User getUser() {
		User ret= new User();
		ret.setUname("武松");
		ret.setUpass("abc123");
		ret.setHead("20.gif");
		ret.setGender(1);
		return ret;
	}
}
