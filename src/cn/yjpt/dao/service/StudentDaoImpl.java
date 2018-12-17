package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import cn.yjpt.bean.Student;
import cn.yjpt.dao.StudentDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class StudentDaoImpl implements StudentDao{
	Connection connection=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub  
		boolean flag=false;
		connection=ConnectionFactory.getConnection();
		String sql="insert into student values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=connection.prepareStatement(sql);
			pstat.setInt(1, student.getSid());
			pstat.setString(2, student.getSname());
			pstat.setString(3, student.getGender());
			pstat.setString(4, student.getIdnumber());
			pstat.setString(5, student.getSchool());
			pstat.setString(6, student.getDepartment());
			pstat.setString(7, student.getMajor());
			pstat.setString(8, student.getEducation());
			pstat.setString(9, student.getEntrancedate());
			pstat.setString(10, student.getNativeplace());
			int i=pstat.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(pstat,connection);
		}
		return flag;
	}

	@Override
	public Student lookStudent(int sid) {
		// TODO Auto-generated method stub
		connection=ConnectionFactory.getConnection();
		String sql="select * from student where sid="+sid;
		Student student=new Student();
		try {
			pstat=connection.prepareStatement(sql);
			rs=pstat.executeQuery();
			if(rs.next()){
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setGender(rs.getString("gender"));
				student.setIdnumber(rs.getString("idnumber"));
				student.setSchool(rs.getString("school"));
				student.setDepartment(rs.getString("department"));
				student.setMajor(rs.getString("major"));
				student.setEducation(rs.getString("education"));
				student.setEntrancedate(rs.getString("entrancedate"));
				student.setNativeplace(rs.getString("nativeplace"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstat, connection);
		}
		return student;
	}

	@Override
	public List<Student> doFindAll() {
		// TODO Auto-generated method stub
		List<Student>studentlist=new ArrayList<Student>();
		connection=ConnectionFactory.getConnection();
		
		try {
			String sql="select * from student";
			pstat=connection.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				//封装student对象
				Student student=new Student();
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setGender(rs.getString("gender"));
				student.setIdnumber(rs.getString("idnumber"));
				student.setSchool(rs.getString("school"));
				//System.out.println(student.getSchool());
				student.setDepartment(rs.getString("department"));
				student.setMajor(rs.getString("major"));
				student.setEducation(rs.getString("education"));
				student.setEntrancedate(rs.getString("entrancedate"));
				student.setNativeplace(rs.getString("nativeplace"));
				
//				向数据集合中添加元素
				studentlist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstat, connection);
		}
		
		return studentlist;
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		connection=ConnectionFactory.getConnection();
		String sql="delete from student where sid="+sid;
		try {
			pstat=connection.prepareStatement(sql);
			int i=pstat.executeUpdate();
			if(i>0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}
	

}
