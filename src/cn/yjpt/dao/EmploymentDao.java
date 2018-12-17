package cn.yjpt.dao;


import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Employment;

public interface EmploymentDao {
	boolean addEmployment(Employment employment);

	//定义方法修改企业基本信息 
		boolean updateEmployment(Employment employment);
		//定义方法查询企业基本信息
		Employment lookEmployment(int eid);
		//定义方法删除企业基本信息
		boolean deleteEmployment(int eid); 
		//定义方法获取企业表中总记录数
		int doCount(DoPage dopage);
		//定义方法获取总页数
		int doTotalPage(DoPage dopage);
		//定义方法查询某一页要显示的数据
		DoPage doFindAll(DoPage dopage);

}
