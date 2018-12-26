package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Resume;

public interface ResumeDao {
	public boolean addResume(Resume resume);

	public Resume lookResume(int sid);

	public boolean updateResume(Resume resume);

	public boolean deleteResume(int sid);

	// 定义方法获取总记录数
	public int doCount(DoPage dopage);

	// 定义方法获取总页数
	public int doTotalPage(DoPage dopage);

	// 查询某一页所有的数据
	public DoPage doFindAll(DoPage dopage);
}
