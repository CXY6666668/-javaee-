package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yjpt.bean.recuritresume;
import cn.yjpt.dao.RecuritResumeDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class RecuritResumeImpl implements RecuritResumeDao {
	Connection connection = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	@Override
	public boolean addRecuritResume(recuritresume recuritresume) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "insert into recruitresume values(?,?,?)";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, recuritresume.getRid());
			pstat.setInt(2, recuritresume.getCid());
			pstat.setInt(3, recuritresume.getSid());
			int i = pstat.executeUpdate();
			System.out.println("输入来" + recuritresume);
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
	public List<Integer> lookResumesByRid(int rid) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		connection = ConnectionFactory.getConnection();
		String sql = "select * from recruitresume where rid=" + rid;
		try {
			pstat = connection.prepareStatement(sql);
			rs = pstat.executeQuery();
			// System.out.println("请输出rid的值" + rid);
			while (rs.next()) {
				int sid = rs.getInt("sid");
				list.add(sid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBClose.close(rs, pstat, connection);
		}
		return list;
	}

	@Override
	public List<Integer> lookRecuritsByCid(int cid) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		connection = ConnectionFactory.getConnection();
		System.out.println("cid" + cid);
		String sql = "select * from recurit where cid=" + cid;
		try {
			pstat = connection.prepareStatement(sql);
			rs = pstat.executeQuery();
			while (rs.next()) {
				int rid = rs.getInt("rid");
				list.add(rid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return list;
	}

}
