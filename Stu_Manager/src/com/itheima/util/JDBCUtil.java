package com.itheima.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCUtil {
	
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password= null;
	
	static{
		try {
			//1. 鍒涘缓涓�涓睘鎬ч厤缃璞�
			Properties properties = new Properties();
//			InputStream is = new FileInputStream("jdbc.properties");
			
			
			//浣跨敤绫诲姞杞藉櫒锛屽幓璇诲彇src搴曚笅鐨勮祫婧愭枃浠躲�� 鍚庨潰鍦╯ervlet
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//瀵煎叆杈撳叆娴併��
			properties.load(is);
			
			//璇诲彇灞炴��
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 鑾峰彇杩炴帴瀵硅薄
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
//			Class.forName(driverClass);
			//闈欐�佷唬鐮佸潡 ---> 绫诲姞杞戒簡锛屽氨鎵ц銆� java.sql.DriverManager.registerDriver(new Driver());
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			//2. 寤虹珛杩炴帴 鍙傛暟涓�锛� 鍗忚 + 璁块棶鐨勬暟鎹簱 锛� 鍙傛暟浜岋細 鐢ㄦ埛鍚� 锛� 鍙傛暟涓夛細 瀵嗙爜銆�
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 閲婃斁璧勬簮
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn , Statement st){
		closeSt(st);
		closeConn(conn);
	}

	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
}
