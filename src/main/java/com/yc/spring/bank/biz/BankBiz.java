package com.yc.spring.bank.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void save(int id,double money) {
		//省略参数校验
		adao.update(id,money);//修改余额
		
//		int i=1/0;  引起异常，导致数据库无操作
		
		odao.insert(id,money);//添加流水记录
	}
	
	//转账
	public void transfer(int id1,int id2,double money) {
		save(id1,-money);
		save(id2,money);
	}
	
	
}
