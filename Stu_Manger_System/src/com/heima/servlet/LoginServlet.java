package com.heima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username + password);

		UserDao dao = new UserDaoImpl();
		boolean issuccess = dao.login(username, password);

		if (issuccess) {

			response.getWriter().print("µÇÂ¼³É¹¦");

		} else {
			response.getWriter().print("µÇÂ¼Ê§°Ü");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
