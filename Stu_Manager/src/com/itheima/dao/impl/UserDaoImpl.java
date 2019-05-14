package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.util.JDBCUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String userName , String password) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs   = null;
		try {
			//1. 寰楀埌杩炴帴瀵硅薄
			conn = JDBCUtil.getConn();
			System.out.println(conn.isClosed());
			String sql = "select * from stu_user where username=? and password=?";
			
			//2. 鍒涘缓ps瀵硅薄
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			
			//3. 寮�濮嬫墽琛屻��
			rs = ps.executeQuery();
			
			//濡傛灉鑳藉鎴愬姛绉诲埌涓嬩竴鏉¤褰曪紝閭ｄ箞琛ㄦ槑鏈夎繖涓敤鎴枫�� 
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

}
