package cn.yjpt.dao;



import cn.yjpt.bean.Company;
import cn.yjpt.bean.DoPage;

public interface CompanyDao {
	boolean addCompany(Company company);
	
	boolean update (Company company);

	Company lookCompany(int cid);

	public DoPage doFindAll(DoPage dopage);

	int doTotalPage(DoPage dopage);




}
