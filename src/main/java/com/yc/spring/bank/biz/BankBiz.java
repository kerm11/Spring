package com.yc.spring.bank.biz;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.yc.spring.bank.dao.OprecordDao;
import com.yc.spring.bank.dao.AccountDao;

/**
 * 银行业务类
 * 开户：向Account表中添加一条记录(新增)
 * 存取款：修改Account的余额（修改），记录流水表（新增）
 * 转账：A账号减少（取款），B账号增加（存款）
 * 查询：根据账号查余额
 */

@Service
@Transactional(rollbackFor = {IOException.class,SQLException.class})
public class BankBiz {
	@Autowired
	private AccountDao adao;
	@Autowired
	private OprecordDao odao;
	
	//开户
	public void register(int id,String pwd,double money) {
		/**
		 * jdbcTemplate 每个update都有独立的事务控制
		 * try{
		 * 		业务代码 ==》回调
		 * 		提交操作
		 * }catch(Exception e){
		 * 		回滚操作
		 * }finally{
		 * 		关闭连接
		 * }
		 */		
		//省略参数校验
		adao.insert(pwd,money);
		odao.insert(id,money);
	}
	
	//存取款
	@Transactional( rollbackFor = {BizException.class})
	public void save(int id,double money) throws BizException {
		//省略参数校验
		adao.update(id,money);//修改余额
		//模拟突然出现的异常，比如银行中可能为突然停电等等
	    //如果没有配置事务管理的话会造成，小红账户多了1000而小明账户没有少钱
	
//		try {
			if(money>999) {
				throw new BizException("存取款金额不能大于999！");
			}
//		} catch (BizException e) {
//			// 将该编译器异常转型为运行期异常
//			throw new DataAccessResourceFailureException("异常转型",e);
//		}
		
		
		odao.insert(id,money);//添加流水记录
	}
	
	//转账
	public void transfer(int id1,int id2,double money) throws BizException {
		save(id1,-money);
		save(id2,money);
	}
	
	
}
