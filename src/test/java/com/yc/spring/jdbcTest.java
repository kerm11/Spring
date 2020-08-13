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

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class jdbcTest {

	@Autowired
	private JdbcTemplate  jdbcTemplate; //DBHelper
	
	@Test
	public void test1() {
		jdbcTemplate.update("insert into account values(1,'a',1000)" );
	}
}
