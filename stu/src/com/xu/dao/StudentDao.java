package com.xu.dao;

import java.sql.SQLException;
import java.util.List;

import com.xu.domain.Student;

public interface StudentDao {

	//��ѯ����
	
	int PAGE_SIZE=5;
	
	
	
	List<Student> FindAll ()throws SQLException;
	
	Student  findStudentById(int sid)throws SQLException;
	
	List<Student>  findStudentByPage(int currentPage)throws SQLException;
	
	void insert(Student student)throws SQLException;
	
	void delete(int id)throws SQLException;
	
	void update(Student student)throws SQLException;
	
	int findCount()throws SQLException;
	
	List<Student> searchStudent(String sname,String sgender)throws SQLException;
}
