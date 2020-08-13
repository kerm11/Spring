package com.yc.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//aspectj的切点表达式
	//execution 定义要拦截方法签名的描述
	//execution(  public void 包名。类名。方法名（参数）)
	@Pointcut( ("execution( * com.yc.spring.dao.MySQLUserDao.*(..))") )
	public void aspect1() {
		//切点方法
	}
	
	@Before("aspect1()")
	public void before() {
		System.out.println("======前置增强=====");
	}
	
	@After("aspect1()")
	public void after() {
		System.out.println("======后置增强=====");
	}

	@AfterReturning("aspect1()")
	public void afterReturning() {
		System.out.println("======返回增强=====");
	}
	
	@AfterThrowing("aspect1()")
	public void afterThrowing() {
		System.out.println("======异常增强=====");
	}
	
	/**
	 * 环绕增强
	 */
	public void around() {
		
	}
	
}
