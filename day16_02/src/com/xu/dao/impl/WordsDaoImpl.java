package com.xu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xu.dao.WordsDao;
import com.xu.domain.WordsBean;
import com.xu.util.JDBCUtil02;

public class WordsDaoImpl implements WordsDao {


	/*public boolean checkUserName(String username) {
		
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
	}*/

	@Override
	public List<WordsBean> findWords(String word) {
		try {
			QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
			String sql ="select * from words where words like ? limit ?";
			return runner.query(sql, new BeanListHandler<WordsBean>(WordsBean.class),word+"%",5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
