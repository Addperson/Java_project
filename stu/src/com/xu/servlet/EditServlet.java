package com.xu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xu.domain.Student;
import com.xu.service.StudentService;
import com.xu.service.impl.StudentServiceImpl;

//处理单个学生的更新 ，查询信跳转到更新界面
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int sid = Integer.parseInt(request.getParameter("sid")) ;			
			StudentService service=new StudentServiceImpl();
			Student student =service.findStudentById(sid);
			
			request.setAttribute("stu", student);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
