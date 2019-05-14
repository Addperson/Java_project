package com.xu.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.xu.dao.StudentDao;
import com.xu.dao.impl.StudentDaoImpl;
import com.xu.domain.PageBean;
import com.xu.domain.Student;
import com.xu.service.StudentService;
import com.xu.util.JDBCUtil02;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> FindAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		
		return dao.FindAll();
	}

	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
		
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

	@Override
	public List<Student> searchStudent(String sname,String sgender)throws SQLException{
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent( sname,  sgender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		
		//封装分页数据
		PageBean<Student> pageBean=new PageBean<Student>();
		
		int pageSize=StudentDao.PAGE_SIZE;
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		
		StudentDao dao = new StudentDaoImpl();
		
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);
		
		int count=dao.findCount();
		pageBean.setTotalSize(count);
		
		pageBean.setTotalPage(count%pageSize ==0 ? count/pageSize :(count/pageSize)+1);
	
		return pageBean;
	}
	

}
