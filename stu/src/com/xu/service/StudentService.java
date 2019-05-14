package com.xu.service;

import java.sql.SQLException;
import java.util.List;

import com.xu.domain.PageBean;
import com.xu.domain.Student;

public interface StudentService {
	
	
	List<Student> FindAll ()throws SQLException;
	void insert(Student student)throws SQLException;
	Student  findStudentById(int sid)throws SQLException;
	PageBean  findStudentByPage(int currentPage)throws SQLException;
	void delete(int id)throws SQLException;
	void update(Student student)throws SQLException;
	List<Student> searchStudent(String sname,String sgender)throws SQLException;
}
