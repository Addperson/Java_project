package com.xu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.deploy.InjectionTarget;

import com.xu.domain.PageBean;
import com.xu.service.StudentService;
import com.xu.service.impl.StudentServiceImpl;

 
public class StudentListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		try {
			int currentPage=Integer.parseInt(request.getParameter("currentPage")) ;
			StudentService service=new StudentServiceImpl();
			PageBean pageBean;
			pageBean = service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
