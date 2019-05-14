package com.xu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xu.domain.Student;
import com.xu.service.StudentService;
import com.xu.service.impl.StudentServiceImpl;

 
public class StudentListServlet extends HttpServlet {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//   ��ѯ��Ϣ������ҳ����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			StudentService service= new StudentServiceImpl();
			List<Student> list = service.FindAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
