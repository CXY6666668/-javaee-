package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.Message;
import cn.yjpt.dao.MessageDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class MessageDaoImpl implements MessageDao {
	Connection connection = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "insert into message(id,username,title,msgtime,content) values(?,?,?,?,?)";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, message.getId());
			pstat.setString(2, message.getUsername());
			pstat.setString(3, message.getTitle());
			pstat.setString(4, message.getMsgtime());
			pstat.setString(5, message.getContent());
			System.out.println(message);
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
	public boolean addReply(Message message) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		/*
		 * mid id username title msgtime content reply replytime
		 */
		String sql = "update message set reply=?,replytime=? where mid=?";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, message.getReply());
			pstat.setString(2, message.getReplytime());
			pstat.setInt(3, message.getMid());
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
	public Message lookMessageById(int mid) {
		// TODO Auto-generated method stub
		Message message = new Message();
		connection = ConnectionFactory.getConnection();
		String sql = "select * from message where mid=" + mid;
		try {
			pstat = connection.prepareStatement(sql);
			rs = pstat.executeQuery();
			if (rs.next()) {
				message.setMid(rs.getInt("mid"));
				message.setId(rs.getInt("id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setMsgtime(rs.getString("msgtime"));
				message.setContent(rs.getString("content"));
				message.setReply(rs.getString("reply"));
				message.setReplytime(rs.getString("replytime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return message;

	}

	@Override
	public int doCount(DoPage dopage) {
		// TODO Auto-generated method stub
		// 定义变量count用来保存message表的总记录数
		int count = 0;
		// 1.连接数据库
		connection = ConnectionFactory.getConnection();
		try {
			// 2.查询message表，获取总记录数
			pstat = connection.prepareStatement("select count(*) from message " + dopage.getSql());
			rs = pstat.executeQuery();
			// 3.处理结果集
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return count;
	}

	@Override
	public int doTotalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		// 用totalPage保存总页数
		int totalPage = 0;
		// m为总记录数除以每页显示记录数的商
		int m = doCount(dopage) / dopage.getPageSize();
		// 如果总页数能够整除每页记录数
		if (doCount(dopage) % dopage.getPageSize() == 0) {
			// 总页数为m
			totalPage = m;
		} else {// 如果总页数除以每页记录数有余数
			totalPage = m + 1;// 总页数为m+1
		}
		return totalPage;
	}

	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
		// 定义变量messagelist,用来保存所有查询到的Message对象
		List messagelist = new ArrayList();
		// 1.建立数据库连接
		connection = ConnectionFactory.getConnection();
		try {
			// 2.创建预编译sql的对象
			String sql = "select * from message " + dopage.getSql() + " order by msgtime desc limit "
					+ (dopage.getNowPage() - 1) * dopage.getPageSize() + "," + dopage.getPageSize();
			pstat = connection.prepareStatement(sql);
			// 3.执行查询
			rs = pstat.executeQuery();
			// 4.处理结果集。每一条记录封装为一个Message对象，把Message对象添加到List集合中
			/*
			 * mid id username title msgtime content reply replytime
			 */
			while (rs.next()) {
				Message message = new Message();
				// 读取一条记录封装为一个Message对象
				message.setMid(rs.getInt("mid"));
				message.setId(rs.getInt("id"));
				message.setUsername(rs.getString("username"));
				message.setTitle(rs.getString("title"));
				message.setMsgtime(rs.getString("msgtime"));
				message.setContent(rs.getString("content"));
				message.setReply(rs.getString("reply"));
				message.setReplytime(rs.getString("replytime"));
				// 把封装好的message对象添加到messagelist中
				messagelist.add(message);
			}
			// 把messagelist设置为dopage对象的属性值ֵ
			dopage.setList(messagelist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return dopage;
	}

	@Override
	public boolean deleteMessage(int mid) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "delete from message where mid=" + mid;
		try {
			pstat = connection.prepareStatement(sql);
			flag = pstat.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}
}
