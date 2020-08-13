package com.yc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	//aspectj的切点表达式
	//execution 定义要拦截方法签名的描述
	//execution(  public void 包名.类名.方法名（参数）)
	@Pointcut( ("execution( * com.yc.spring.dao.*Dao.select*(..))") )
	public void aspect1() {
		//切点方法 不需要写代码
	}
	
	@Before("aspect1()")
	//JoinPoint 连接点对象 ==>方法  ==》反射对象Method
	//接口注入
	public void before(JoinPoint jp) {
		jp.getArgs(); //方法参数
		jp.getSignature();//方法签名
		System.out.println("======前置增强=====");
	}
	
	@After("aspect1()")
	public void after(JoinPoint jp) {
		System.out.println("======后置增强=====");
	}

	@AfterReturning("aspect1()")
	public void afterReturning(JoinPoint jp) {
		System.out.println("======返回增强=====");
	}
	
	@AfterThrowing("aspect1()")
	public void afterThrowing(JoinPoint jp) {
		System.out.println("======异常增强=====");
	}
	
	/**
	 * 环绕增强  业务方法需要我们自己来执行
	 */
	@Around("execution( * com.yc.spring.dao.Oracle*.select*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		Object ret=null;
		try {
			//调用业务对象的方法
			long begin = System.currentTimeMillis();
			ret=pjp.proceed();
			long end = System.currentTimeMillis();
			System.out.println("一共消耗了"+((end-begin)/1000)+"秒");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}
	
}
