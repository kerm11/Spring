package com.yc.cinema;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.cinema.web.IndexAction;
import com.yc.cinema.web.MovieAction;
import com.yc.cinema.web.UserAction;
//@ContextConfiguration("beans.xml") xml方式
//Spring提供测试运行器
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class BaseTest {

	@Resource
	private IndexAction iAction;
	@Resource
	private MovieAction mAction;
	@Resource
	private UserAction uAction;

	
	/**
	 * 依赖版本不一致
	 * java.lang.Exception: No tests found matching 
	 		[{ExactMatcher:fDisplayName=test1], {ExactMatcher:fDisplayName=test1(com.yc.cinema.BaseTest)],
	 		 {LeadingIdentifierMatcher:fClassName=com.yc.cinema.BaseTest,fLeadingIdentifier=test1]]
	 		  from org.junit.internal.requests.ClassRequest@4c203ea1
	 */
	@Test
	public void test1() {
		Assert.assertNotNull(uAction);
		Assert.assertNotNull(uAction.getCbiz());
		Assert.assertNotNull(uAction.getUbiz());
		Assert.assertNotNull(uAction.getCbiz().getCdao());
		Assert.assertNotNull(uAction.getCbiz().getMdao());
		Assert.assertNotNull(uAction.getCbiz().getUbiz());
		Assert.assertNotNull(uAction.getUbiz().getUdao());
	}
	
	@Test
	public void test2() {
		Assert.assertNotNull(iAction);
		Assert.assertNotNull(iAction.getHbiz());
		Assert.assertNotNull(iAction.getMbiz());
		Assert.assertNotNull(iAction.getUbiz());
		Assert.assertNotNull(iAction.getHbiz().getHdao());
		Assert.assertNotNull(iAction.getHbiz().getMbiz());
		Assert.assertNotNull(iAction.getMbiz().getAdao());
		Assert.assertNotNull(iAction.getMbiz().getMadao());
		Assert.assertNotNull(iAction.getMbiz().getMidao());
		Assert.assertNotNull(iAction.getMbiz().getMtdao());
		Assert.assertNotNull(iAction.getUbiz().getUdao());
	}

	@Test
	public void test3() {
		Assert.assertNotNull(mAction);
		Assert.assertNotNull(mAction.getAbiz());
		Assert.assertNotNull(mAction.getCbiz());
		Assert.assertNotNull(mAction.getUbiz());
		Assert.assertNotNull(mAction.getAbiz().getAdao());
		Assert.assertNotNull(mAction.getCbiz().getCdao());
		Assert.assertNotNull(mAction.getCbiz().getMdao());
		Assert.assertNotNull(mAction.getCbiz().getUbiz());
		Assert.assertNotNull(mAction.getUbiz().getUdao());
	}

}
