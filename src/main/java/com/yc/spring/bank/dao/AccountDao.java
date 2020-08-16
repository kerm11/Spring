package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Account;

/**
 * 银行账号
 * @author 邹蔓
 *
 */
@Repository
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert (String pwd,double money) {
		return jdbcTemplate.update("insert into account values(null,?,?)", pwd,money);		
	}
	
	//根据id修改余额
	public int update(int id,double money) {
		return jdbcTemplate.update("update  account set balance = balance+ ? where accountid = ? ", money,id);		
	}
	
	//查询
	public Account selectById(int id) {
		String sql="select * from account where accountid=?";
		Object[] args = {id};
		
		//ResultSetExtractor 是回调接口，用于将结果集中的数据转换成Account对象
		return jdbcTemplate.query(sql, args, new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				Account acc= new Account();
				acc.setAccountid(rs.getInt("accountid"));
				acc.setPassword(rs.getString("password"));
				acc.setBalance(rs.getDouble("balance"));
				return acc;
			}
			
		});
	}
}
