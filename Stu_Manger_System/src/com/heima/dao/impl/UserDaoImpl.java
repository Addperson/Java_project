package com.heima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.heima.dao.UserDao;
import com.heima.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	public boolean login(String username, String password) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
        boolean flag=false;
		try {
			conn = JDBCUtil.getconn();

			String sql = "select * from stu_user where username=?and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("µÇÂ½³É¹¦");
				
				flag=true;
			} else {
				System.out.println("µÇÂ½Ê§°Ü");

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return flag;
	}

}
