package com.heima.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCUtil {
	
	static String url=null;
	static String username=null;
	static String password=null;
	static String driverclass=null;
	static{
		
		try {
			Properties properties=new Properties();
//			InputStream is = new FileInputStream("jdbc.properties");
			InputStream is =JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
			properties.load(is);
			
			driverclass=properties.getProperty("driverclass");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			
			System.out.println(url+username+password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//获取连接对象
	public static Connection getconn(){
		
		Connection conn=null;
		
		
			
				//Class.forName("com.mysql.jdbc.Driver");
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					
					  
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 return conn;
		 
	}
	
	
	
	
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		
		closeconn(conn);
		closers(rs);
		closest(st);
		
		
	}

	
	private static void closers(ResultSet rs){
		
		try {
			if (rs!=null) {
				rs.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rs=null;
		}
	}
	
	private static void closest(Statement  st){
			
			try {
				if (st!=null) {
					st.close();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				st=null;
			}
		}

	private static void closeconn(Connection conn){
			
			try {
				if (conn!=null) {
					conn.close();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				conn=null;
			}
}


	
	
	
	
	
	
	
}
