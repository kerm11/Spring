package com.yc.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import com.yc.spring.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(  classes = AOPConfig.class)
public class AOPTest {
	@Autowired	
	@Qualifier("mdao") //指定注入的组件的id
	private UserDao mdao;
//	private MySQLUserDao mdao;
	@Autowired
	@Qualifier("odao")
	private UserDao odao;
//	private OracleUserDao odao;
	@Test
	public void test1() {
		System.out.println("======1=====");
		mdao.selectUserId("");
		System.out.println("======2=====");
		odao.selectUserId("");
		System.out.println("======3=====");
	}
}
