package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Employment;
import cn.yjpt.dao.EmploymentDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class EmploymentDaoImpl implements EmploymentDao {
	Connection connection=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;


	@Override
	public boolean addEmployment(Employment employment) {
		// TODO Auto-generated method stub
		boolean flag=false;
	connection=ConnectionFactory.getConnection();
	String sql="insert into employment values(?,?,?,?,?)";
	try {
		pstat=connection.prepareStatement(sql);
		pstat.setInt(1, employment.getEid());
		pstat.setString(2, employment.getStudentusername());
		pstat.setString(3, employment.getSchool());
		pstat.setString(4, employment.getCompanyname());
		pstat.setString(5, employment.getPosition());
		int i=pstat.executeUpdate();
		if(i>0) {
			flag=true;
		}else {
			flag=false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}

	@Override
	public int doCount(DoPage dopage) {
		// TODO Auto-generated method stub
		//����count�����ܼ�¼��
		int count =0;
		connection=ConnectionFactory.getConnection();
		try {
			pstat=connection.prepareStatement("select count(*)  from employment"+dopage.getSql());
			rs=pstat.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(null, pstat, connection);
		}
		return count;
	}

	@Override
	public int doTotalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		int totalPage=0;
//		����m�����ܼ�¼������ÿҳ��¼������
		int m=doCount(dopage)/dopage.getPageSize();
		if(doCount(dopage)%dopage.getPageSize()>0){
			totalPage=m+1;
			
		}else{
			totalPage=m;
		}
		return totalPage;
	}
//���巽����ѯĳһҳҪ��ʾ������

	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
//		����List����list�����ѯ�������еļ�¼��װ��user�Ķ���
		List employmentlist=new ArrayList();
		//1.��ȡ�����ݵ�����
		connection=ConnectionFactory.getConnection();
		try {
			 pstat=connection.prepareStatement("select * from employment "+dopage.getSql()+" limit "
						+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			//String sql="select * from employment";
			//pstat=connnection.prepareStatement("select * from employment"+dopage.getSql()+"limit"+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			//pstat=connection.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				Employment employment=new Employment();
				employment.setEid(rs.getInt("eid"));
				employment.setStudentusername(rs.getString("studentusername"));
				employment.setSchool(rs.getString("school"));
				employment.setCompanyname(rs.getString("companyname"));
				employment.setPosition(rs.getString("position"));
				employmentlist.add(employment);
			}
			dopage.setList(employmentlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstat, connection);
		}
		return dopage;
	}

	@Override
	public boolean updateEmployment(Employment employment) {
		// TODO Auto-generated method stub
	/*	boolean flag=false;		
		//1.�������ݿ� 
		   connnection=ConnectionFactory.getConnection();
		   String sql="update employment set studentusername=?,school=?,companyname=?,position=? where eid=?";
		   try {
			   //2.����PreparedStatement����
			   pstat=connnection.prepareStatement(sql);			   
			   pstat.setString(1,employment.getStudentusername());
			   pstat.setString(2,employment.getSchool());
			   pstat.setString(3,employment.getCompanyname());
			   pstat.setString(4,employment.getPosition());
			   pstat.setInt(5,employment.getEid());	
			   
			   //3.ִ���޸�
			   int i=pstat.executeUpdate();
			 //  System.out.println("���"+i);
			   if(i>0){
				   flag=true;
			   }			   
		    } catch (SQLException e) {		
			   e.printStackTrace();
		    }finally{
		    	DBClose.close(pstat, connnection);
		    }
		 //4.���ؽ��
		return flag;
	}*/
		boolean flag=false;		
	//1.�������ݿ�
	   connection=ConnectionFactory.getConnection();
	   String sql="update employment set studentusername=?,school=?,companyname=?,position=? where eid=?";
	   try {
		   //2.����PreparedStatement����
		   pstat=connection.prepareStatement(sql);			   
		   pstat.setString(1,employment.getStudentusername());
		   pstat.setString(2,employment.getSchool());
		   pstat.setString(3,employment.getCompanyname());
		   pstat.setString(4,employment.getPosition());
		   pstat.setInt(5,employment.getEid());			   
		   //3.ִ���޸�
		   int i=pstat.executeUpdate();
		   if(i>0){
			   flag=true;
		   }			   
	    } catch (SQLException e) {		
		   e.printStackTrace();
	    }finally{
	    	DBClose.close(pstat, connection);
	    }
	 //4.���ؽ��
	return flag;
}

	@Override
	public Employment lookEmployment(int eid) {
		// TODO Auto-generated method stub
		 Employment employment=new Employment();
		  connection=ConnectionFactory.getConnection();	  
		  String sql="select * from employment where eid="+eid;
		  try {
			pstat=connection.prepareStatement(sql);
			rs=pstat.executeQuery();
			if(rs.next()){
				employment.setEid(rs.getInt("eid"));
				employment.setStudentusername(rs.getString("studentusername"));
				employment.setSchool(rs.getString("school"));
				employment.setCompanyname(rs.getString("companyname"));
				employment.setPosition(rs.getString("position"));
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			DBClose.close(rs, pstat, connection);
		}
		return employment;
	}

	@Override
	public boolean deleteEmployment(int eid) {
		// TODO Auto-generated method stub
		boolean flag=false;
	  	connection=ConnectionFactory.getConnection();
	  	String sql="delete from employment where eid="+eid;
	  	try {
				pstat=connection.prepareStatement(sql);			
				flag=pstat.executeUpdate()>0?true:false;
			} catch (SQLException e) {				
				e.printStackTrace();
			}finally{
				DBClose.close(pstat, connection);
			}			
			return flag;
	}

	
	}

