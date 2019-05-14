package com.xu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xu.dao.StudentDao;
import com.xu.domain.Student;
import com.xu.util.JDBCUtil02;
import com.xu.util.TextUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> FindAll() throws SQLException  {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
		
	
		
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into stu value(null,?,?,?,?,?,?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where sid=?",sid);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu where sid=?";
		Student student= runner.query(sql, new BeanHandler<Student>(Student.class),sid);
		return student;
	}

	@Override
	public void update(Student student)throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="update stu set sname=?,gender=?,phone=?,birthday=?, hobby=? ,info=? where sid=?";
		runner.update(sql, 
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid());
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu where 1=1";
		List<String> list = new ArrayList<String> ();
		if(!TextUtil.isEmpty(sname)){
			sql = sql + " and sname like ?";
			list.add("%"+sname+"%");
		}
		
		
		if(!TextUtil.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		
		
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
		
		
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu limit ? offset ?";
		List<Student> list= runner.query(sql, new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
		return list;
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select count(*) from stu ";
		Long result = (Long)runner.query(sql, new ScalarHandler());
		return result.intValue();
		
	}

}
