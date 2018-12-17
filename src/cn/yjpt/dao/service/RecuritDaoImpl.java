package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Recurit;
import cn.yjpt.dao.RecuritDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class RecuritDaoImpl implements RecuritDao {
	Connection connection = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	public boolean addRecurit(Recurit recurit) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "insert into recurit(cid,companyname,address,postcode,recruitment,workingplace,positiontype,edurequire,description,branch,linkman,telephone,hostpage,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, recurit.getCid());
			pstat.setString(2, recurit.getCompanyname());
			pstat.setString(3, recurit.getAddress());
			pstat.setString(4, recurit.getPostcode());
			pstat.setString(5, recurit.getRecruitment());
			pstat.setString(6, recurit.getWorkingplace());
			pstat.setString(7, recurit.getPositiontype());
			pstat.setString(8, recurit.getEdurequire());
			pstat.setString(9, recurit.getDescription());
			pstat.setString(10, recurit.getBranch());
			pstat.setString(11, recurit.getLinkman());
			pstat.setString(12, recurit.getTelephone());
			pstat.setString(13, recurit.getHostpage());
			System.out.print(recurit.getHostpage());
			pstat.setString(14, recurit.getEmail());
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}

	@Override
	public boolean updateRecurit(Recurit recurit) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "update recurit set companyname=?,address=?,positiontype=?,recruitment=?,workingplace=?,positiontype=?,edurequire=?,description=?,branch=?,linkman=?,telephone=?,hostpage=?,email=? where rid=?";
		try {
			pstat = connection.prepareStatement(sql);
			// pstat.setInt(1, recurit.getCid());
			pstat.setString(1, recurit.getCompanyname());
			pstat.setString(2, recurit.getAddress());
			pstat.setString(3, recurit.getPositiontype());
			pstat.setString(4, recurit.getRecruitment());
			pstat.setString(5, recurit.getWorkingplace());
			pstat.setString(6, recurit.getPositiontype());
			pstat.setString(7, recurit.getEdurequire());
			pstat.setString(8, recurit.getDescription());
			pstat.setString(9, recurit.getBranch());
			pstat.setString(10, recurit.getLinkman());
			pstat.setString(11, recurit.getTelephone());
			pstat.setString(12, recurit.getHostpage());
			pstat.setString(13, recurit.getEmail());
			pstat.setInt(14, recurit.getRid());
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}

		return flag;
	}

	@Override
	public boolean deleteRecurit(int rid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("delete from recurit where rid=" + rid);
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}

	@Override
	public Recurit lookRecurit(int rid) {
		// TODO Auto-generated method stub
		connection = ConnectionFactory.getConnection();
		String sql = "select * from recurit where rid=" + rid;
		Recurit recurit = new Recurit();
		try {
			pstat = connection.prepareStatement(sql);
			rs = pstat.executeQuery();
			if (rs.next()) {
				recurit.setRid(rs.getInt("rid"));
				recurit.setCid(rs.getInt("cid"));
				recurit.setCompanyname(rs.getString("companyname"));
				recurit.setAddress(rs.getString("address"));
				recurit.setPostcode(rs.getString("postcode"));
				recurit.setRecruitment(rs.getString("recruitment"));
				recurit.setWorkingplace(rs.getString("workingplace"));
				recurit.setPositiontype(rs.getString("positiontype"));
				recurit.setEdurequire(rs.getString("edurequire"));
				recurit.setDescription(rs.getString("description"));
				recurit.setBranch(rs.getString("branch"));
				recurit.setLinkman(rs.getString("linkman"));
				recurit.setTelephone(rs.getString("telephone"));
				recurit.setHostpage(rs.getString("hostpage"));
				recurit.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}

		return recurit;
	}

	@Override
	public int doCount(DoPage dopage) {
		// TODO Auto-generated method stub
		// 定义count代表总记录数
		int count = 0;
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("select count(*)  from recurit" + dopage.getSql());
			rs = pstat.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(null, pstat, connection);
		}
		return count;
	}

	@Override
	public int doTotalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("select * from recurit " + dopage.getSql() + " limit "
					+ (dopage.getNowPage() - 1) * dopage.getPageSize() + "," + dopage.getPageSize());
			rs = pstat.executeQuery();
			while (rs.next()) {
				Recurit recurit = new Recurit();
				recurit.setRid(rs.getInt("rid"));
				recurit.setCid(rs.getInt("cid"));
				recurit.setCompanyname(rs.getString("companyname"));
				recurit.setAddress(rs.getString("address"));
				recurit.setPostcode(rs.getString("postcode"));
				recurit.setRecruitment(rs.getString("recruitment"));
				recurit.setWorkingplace(rs.getString("workingplace"));
				recurit.setPositiontype(rs.getString("positiontype"));
				recurit.setEdurequire(rs.getString("edurequire"));
				recurit.setDescription(rs.getString("description"));
				recurit.setBranch(rs.getString("branch"));
				recurit.setLinkman(rs.getString("linkman"));
				recurit.setTelephone(rs.getString("telephone"));
				recurit.setHostpage(rs.getString("hostpage"));
				recurit.setEmail(rs.getString("email"));
				list.add(recurit);
			}
			dopage.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return dopage;
	}

}
