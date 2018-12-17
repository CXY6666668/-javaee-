package cn.yjpt.dao;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Recurit;

public interface RecuritDao {
	boolean addRecurit(Recurit recurit);

	// 定义方法修改招聘信息
	public boolean updateRecurit(Recurit recurit);

	// 定义方法删除招聘信息
	public boolean deleteRecurit(int rid);

	// 定义方法查询招聘信息
	public Recurit lookRecurit(int rid);

	// 定义方法查询总记录数
	public int doCount(DoPage dopage);

	// 定义方法查询总页数
	public int doTotalPage(DoPage dopage);

	// 定义方法查询某一页需显示的记录
	public DoPage doFindAll(DoPage dopage);
}
