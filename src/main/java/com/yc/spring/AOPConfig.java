package com.yc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yc.spring")
/**
 * AOP 不是Spring 提供的概念
 * Spring 对AOP的依赖AspectJ框架
 * */
@EnableAspectJAutoProxy     //对应<aop:aspectj-autoproxy/>
public class AOPConfig {

}
