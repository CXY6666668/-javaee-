package cn.yjpt.dao;

import java.util.List;

import cn.yjpt.bean.Student;

public interface StudentDao {
//	定义方法添加学生的基本信息
	boolean addStudent(Student student);
	
//	定义方法查询学生的基本信息
	Student lookStudent(int sid);
	
//	查询所有学生的数据信息
	public List<Student>doFindAll();
	
//	删除 
	public boolean deleteStudent(int sid);
	
}
