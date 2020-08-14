package com.yc.spring;

/**
 * java.lang.Exception: No tests found matching [{ExactMatcher:fDisplayName=test1], 
 * {ExactMatcher:fDisplayName=test1(com.yc.spring.jdbcTest)],
 *  {LeadingIdentifierMatcher:fClassName=com.yc.spring.jdbcTest,fLeadingIdentifier=test1]] 
 *  from org.junit.internal.requests.ClassRequest@47089e5f
	at org.junit.internal.requests.FilterRequest.getRunner(FilterRequest.java:40)
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bank.biz.BankBiz;

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class JdbcTest {

	@Autowired
	private JdbcTemplate  jdbcTemplate; //DBHelper

	@Autowired
	private BankBiz bbiz;
	
	@Test
	public void test1() {
		jdbcTemplate.update("insert into account values(null,'a',1000)" );
	}
	
	
	@Test
	public void test2() {
		bbiz.register(6,"a",2000);
	}
	
	@Test
	public void test3() {
		bbiz.save(6,500);//使账户增加500,并增加流水记录
	}
	
	
	@Test
	public void test4() {
		bbiz.transfer(3,6,1000);//3给6转账1000,并增加流水记录
	}
	
}
