package com.yc.cinema;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//aspect的切点表达式
	//execution 定义要拦截方法签名的描述
	//execution(  public void 包名。类名。方法名（参数）)
	@Pointcut( ("execution( * com.yc.spring.dao.MySQLUserDao.*(..))") )
	public void aspect1() {//切点方法
		
	}
	
	@Before("aspect1()")
	public void before() {
		System.out.println("===========");
	}
}
