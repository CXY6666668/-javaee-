package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yjpt.bean.Company;
import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Student;
import cn.yjpt.dao.CompanyDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class CompanyDaoImpl implements CompanyDao {
	Connection connection=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	@Override
	public boolean addCompany(Company company) {
		// TODO Auto-generated method stub
		boolean flag=false;
		connection=ConnectionFactory.getConnection();
		String sql="insert into company values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat=connection.prepareStatement(sql);
			pstat.setInt(1, company.getCid());
			pstat.setString(2, company.getCompanyname());
			pstat.setString(3, company.getEmail());
			pstat.setString(4, company.getIndustry());
			pstat.setString(5, company.getAddress());
			pstat.setString(6, company.getLicensenumber());
			pstat.setString(7, company.getLinkman());
			pstat.setString(8, company.getPostcode());
			pstat.setString(9, company.getTelephone());
			pstat.setString(10, company.getUnitproperty());
			pstat.setString(11, company.getWebaddress());
			pstat.setString(12, company.getUnitscale());
			int i=pstat.executeUpdate();
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(rs,pstat, connection);
		}
		
		return flag;
	}
	@Override
	public boolean update(Company company) {
		// TODO Auto-generated method stub
		boolean flag=false;
		connection=ConnectionFactory.getConnection();
		String sql="update company set companyname=?,unitproperty=?,industry=?,licensenumber=?,unitscale=?,address=?,webaddress=?,linkman=?,telephone=?,email=?,postcode=? where cid=?";
		try {
			pstat=connection.prepareStatement(sql);
			pstat.setString(1, company.getCompanyname());
			pstat.setString(2, company.getUnitproperty());
			pstat.setString(3, company.getIndustry());
			pstat.setString(4, company.getLicensenumber());
			pstat.setString(5, company.getUnitscale());
			pstat.setString(6, company.getAddress());
			pstat.setString(7, company.getWebaddress());
			pstat.setString(8, company.getLinkman());
			pstat.setString(9, company.getTelephone());
			pstat.setString(10, company.getEmail());
			pstat.setString(11, company.getPostcode());
			pstat.setInt(12, company.getCid());
			int i=pstat.executeUpdate();
			if(i>0){
				flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}
	@Override
	public Company lookCompany(int cid) {
		// TODO Auto-generated method stub
		connection=ConnectionFactory.getConnection();
		String sql="select * from company where cid="+cid;
		Company company=new Company();
		try {
			pstat=connection.prepareStatement(sql);
			rs=pstat.executeQuery();
			if(rs.next()){
				company.setCid(rs.getInt("cid"));
				company.setCompanyname(rs.getString("companyname"));
				company.setAddress(rs.getString("address"));
				company.setEmail(rs.getString("email"));
				company.setIndustry(rs.getString("industry"));
				company.setLicensenumber(rs.getString("licensenumber"));
				company.setLinkman(rs.getString("linkman"));
				company.setPostcode(rs.getString("postcode"));
				company.setTelephone(rs.getString("telephone"));
				company.setUnitproperty(rs.getString("unitproperty"));
				company.setUnitscale(rs.getString("unitscale"));
				company.setWebaddress(rs.getString("webaddress"));
			}else {
				company.setCid(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBClose.close(pstat, connection);
		}
		return company;
	}
	 //���巽����ѯĳһҳҪ��ʾ������
	  public DoPage doFindAll(DoPage dopage){
		//����List����list�����ѯ�������м�¼��װ��company����
		  List list=new ArrayList(); 
		  //1.��ȡ�����ݿ�����
		  connection=ConnectionFactory.getConnection();
		  try {
			//2.ִ��������ѯ������PreparedStatement����
			  pstat=connection.prepareStatement("select * from company "+dopage.getSql()+" limit "
			+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			  //3.ִ�в�ѯ
			  rs=pstat.executeQuery();
			  //4.��������
			  while(rs.next()){
				 Company company=new Company();
				//�ò�ѯ�ļ�¼���ֶε�ֵ��Ϊ��������Ϊcompany���������ֵ
				 company.setCid(rs.getInt("cid"));
				 company.setCompanyname(rs.getString("companyname"));
				 company.setUnitproperty(rs.getString("unitproperty"));
				 company.setLicensenumber(rs.getString("licensenumber"));
				 company.setIndustry(rs.getString("industry"));
				 company.setUnitscale(rs.getString("unitscale"));
				 company.setAddress(rs.getString("address"));
				 company.setWebaddress(rs.getString("webaddress"));
				 company.setLinkman(rs.getString("linkman"));
				 company.setTelephone(rs.getString("telephone"));
				 company.setEmail(rs.getString("email"));
				 company.setPostcode(rs.getString("postcode")); 			 
				//�ѷ�װ�õ�user������ӵ��б������
				 list.add(company);
			  }		 
			  dopage.setList(list); //��list����Ϊdopage����ĳ�Ա����ֵ
		 } catch (SQLException e) {		
			e.printStackTrace();
		 }finally{
			 DBClose.close(rs, pstat, connection);
		 }
		  //5.���ز�ѯ�����װ�Ķ���
		  return dopage;
	  }
	@Override
	public int doTotalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		return 0;
	}		
}

