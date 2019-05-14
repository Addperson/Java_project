package com.xu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xu.dao.CityDao;
import com.xu.domain.CityBean;

import com.xu.util.JDBCUtil02;

public class CityDaoImpl implements CityDao{

	@Override
	public List<CityBean> findCity(int pid) {
		try {
			QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
			String sql="select * from city where pid=?";
			return runner.query(sql, new BeanListHandler<CityBean>(CityBean.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
