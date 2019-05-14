package com.xu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xu.domain.Student;
import com.xu.service.StudentService;
import com.xu.service.impl.StudentServiceImpl;

 
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");		
		
		Date date;
		try {
			int sid= Integer.parseInt(request.getParameter("sid"));
			String name = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String info = request.getParameter("info");
			String[] h = request.getParameterValues("hobby");
			String hobby=Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length()-1);
			date = new SimpleDateFormat("yy-MM-dd").parse(birthday);
			
			Student student = new Student(sid,name, gender, phone, hobby, info, date);	
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
