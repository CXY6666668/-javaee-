package cn.yjpt.dao;

import java.util.List;

import cn.yjpt.bean.recuritresume;

public interface RecuritResumeDao {
	// 定义方法学生投递简历
	boolean addRecuritResume(recuritresume recuritresume);

	// 定义方法根据招聘id查询所有投递的简历id集合
	List<Integer> lookResumesByRid(int sid);

	// 定义方法查询某个公司收到学生简历的招聘信息id集合
	List<Integer> lookRecuritsByCid(int cid);

}
