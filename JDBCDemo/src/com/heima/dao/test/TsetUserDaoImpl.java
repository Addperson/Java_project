package com.heima.dao.test;

import org.junit.Test;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;

public class TsetUserDaoImpl {
	@Test
	public void testFindAll(){
		
		UserDao dao = new UserDaoImpl();
		dao.findall();
		
		dao.login("admin", "admin");
	}

}
