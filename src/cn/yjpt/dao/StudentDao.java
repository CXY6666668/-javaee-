package cn.yjpt.dao;

import java.util.List;

import cn.yjpt.bean.Student;

public interface StudentDao {
//	���巽�����ѧ���Ļ�����Ϣ
	boolean addStudent(Student student);
	
//	���巽����ѯѧ���Ļ�����Ϣ
	Student lookStudent(int sid);
	
//	��ѯ����ѧ����������Ϣ
	public List<Student>doFindAll();
	
//	ɾ�� 
	public boolean deleteStudent(int sid);
	
}
