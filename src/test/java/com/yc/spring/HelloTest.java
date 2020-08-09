package com.yc.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.UserDao;



public class HelloTest {
	
	
	private ClassPathXmlApplicationContext ctx;
	@Before
	public void before() {
		ctx = new 	ClassPathXmlApplicationContext("beans.xml");
	}
	
	@After
	public void after() {
		ctx.close();
	}
	//Hello h =new  Hello();
	/**
	 * Spring 框架解决的问题
	 * Servlet
	 * 		UserBiz ubiz = new UserBiz();
	 * 1.   new ==>  创建对象 ==>内存中占用存储对象的空间
	 * 				每次new都会创建一个新的对象 ==>内存消耗大
	 * 				解决的方式：使用对象池
	 * 				对象池.get对象 获取对象
	 * 2.耦合性问题
	 * 				对象可以任意在运行期设置为指定的子类现实类
	 * 
	 * 		控制反转
	 * 				对象创建由程序员决定
	 * 				对象的创建由容器决定
	 */
	@Test
	public void test() {
		//从Spring 框架(容器)中获取一个Hello对象
		//创建Spring容器对象
		ClassPathXmlApplicationContext ctx = new 	ClassPathXmlApplicationContext("beans.xml");

		Hello h =(Hello)ctx.getBean("hello");
		
		Hello h1 =(Hello)ctx.getBean("hello");
		Hello h2 =(Hello)ctx.getBean("hello");
		
		//h1和h2是同一个对象
		System.out.println(h1==h2);
		//执行sayHello方法
		h.sayHello();
		
		ctx.close();
	}
	
	@Test
	public void test1() {
		ClassPathXmlApplicationContext ctx = new 	ClassPathXmlApplicationContext("beans.xml");
		//UserDao udao1=new MySQLUserDao();
		UserDao udao1 = (UserDao) ctx.getBean("mdao");
		UserDao udao2 = (UserDao) ctx.getBean("mdao");
		
		udao1.selectUserId("zhangsan");
		udao2.selectUserId("zhangsan");
		ctx.close();
	}

	@Test
	public void test2() {
		Person p1 = (Person) ctx.getBean("p1");
		Assert.assertEquals("武松", p1.getName());
		Assert.assertEquals(35, p1.getAge());
		Assert.assertEquals(5, p1.getKilleds().size());
		Assert.assertEquals("蒋门神",  p1.getKilleds().get(2));
	}
}
