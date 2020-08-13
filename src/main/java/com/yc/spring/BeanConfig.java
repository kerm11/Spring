package com.yc.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.MySQLUserDao;


/**
 * 注解方式配置IOC容器
 * @author 邹蔓
 *
 */
@Configuration //IOC容器配置类的注解 ==>beans.xml
@ComponentScan("com.yc.spring")//扫描该包和它的所有子包
public class BeanConfig {

	//xml中的每一个bean对应java的一个方法，这个方法返回bean对象
	//方法名没有限定
//	@Bean(name="hello")
//	public Hello getHello() {
//		return new Hello();
//	}
//	
//	@Bean(name="odao")
//	public OracleUserDao getOracleUserDao() {
//		return new OracleUserDao();
//	}

	@Bean(name="mdao")
	public MySQLUserDao getMySQLUserDao() {
		return new MySQLUserDao();
	}
	
	@Bean(name="p1")
	public Person getPerson1() {
		Person ret= new Person();
		ret.setName("武松");
		ret.setAge(35);
		ret.setKilleds(new ArrayList<String>());
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("蒋门神");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		return ret;
	}
	
	@Bean(name="Person")
	@Primary
	public Person getPerson3() {
		Person ret= new Person();
		ret.setName("李逵");
		ret.setAge(33);
		
		return ret;
	}
	
	@Bean(name="p2")
	public Person getPerson4() {
		Person ret= new Person();
		ret.setName("吴用");
		ret.setAge(38);
		ret.setFriend(new Person());
		ret.getFriend().setName("华荣");		
		return ret;
	}
	
	@Bean(name="p5")
	public Person getPerson5() {
		Person p =Person.PersonFactory();
		p.setName("王英");
		return p;
	}
	
	@Bean(name="p6")
	public Person getPerson6() {
		Person ret =Person.PersonFactory();
		ret.setName("扈三娘");
		ret.setAge(20);
		return ret;
	}
	
	@Bean(name="hello2")
	public Hello getHello7() {
		Hello h= new Hello();
		h.sayHello();
		return h;
	}
	
	@Bean("p7")
	public Person getPerson7() {
		Person ret= new Person();
		ret.setFriend(new Person());
		ret.getFriend().setName("华荣");		
		return ret;
	}
}
