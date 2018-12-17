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
		//定义count代表总记录数
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
//		定义m保存总记录数除以每页记录数的商
		int m=doCount(dopage)/dopage.getPageSize();
		if(doCount(dopage)%dopage.getPageSize()>0){
			totalPage=m+1;
			
		}else{
			totalPage=m;
		}
		return totalPage;
	}
//定义方法查询某一页要显示的数据

	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
//		声明List对象list保存查询到的所有的记录封装的user的对象
		List employmentlist=new ArrayList();
		//1.获取和数据的连接
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
		//1.连接数据库 
		   connnection=ConnectionFactory.getConnection();
		   String sql="update employment set studentusername=?,school=?,companyname=?,position=? where eid=?";
		   try {
			   //2.创建PreparedStatement对象
			   pstat=connnection.prepareStatement(sql);			   
			   pstat.setString(1,employment.getStudentusername());
			   pstat.setString(2,employment.getSchool());
			   pstat.setString(3,employment.getCompanyname());
			   pstat.setString(4,employment.getPosition());
			   pstat.setInt(5,employment.getEid());	
			   
			   //3.执行修改
			   int i=pstat.executeUpdate();
			 //  System.out.println("输出"+i);
			   if(i>0){
				   flag=true;
			   }			   
		    } catch (SQLException e) {		
			   e.printStackTrace();
		    }finally{
		    	DBClose.close(pstat, connnection);
		    }
		 //4.返回结果
		return flag;
	}*/
		boolean flag=false;		
	//1.连接数据库
	   connection=ConnectionFactory.getConnection();
	   String sql="update employment set studentusername=?,school=?,companyname=?,position=? where eid=?";
	   try {
		   //2.创建PreparedStatement对象
		   pstat=connection.prepareStatement(sql);			   
		   pstat.setString(1,employment.getStudentusername());
		   pstat.setString(2,employment.getSchool());
		   pstat.setString(3,employment.getCompanyname());
		   pstat.setString(4,employment.getPosition());
		   pstat.setInt(5,employment.getEid());			   
		   //3.执行修改
		   int i=pstat.executeUpdate();
		   if(i>0){
			   flag=true;
		   }			   
	    } catch (SQLException e) {		
		   e.printStackTrace();
	    }finally{
	    	DBClose.close(pstat, connection);
	    }
	 //4.返回结果
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

