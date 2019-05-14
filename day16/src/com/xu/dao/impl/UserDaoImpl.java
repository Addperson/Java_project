package com.xu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xu.dao.UserDao;
import com.xu.util.JDBCUtil02;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUserName(String username) {
		
		long result = 0;
		try {
			QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
			String sql ="select count(*)from stu_user where username=?";
			
			result = (long)runner.query(sql, new ScalarHandler(),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}

}
