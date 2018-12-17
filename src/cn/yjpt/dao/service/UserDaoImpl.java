package cn.yjpt.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yjpt.bean.DoPage;
import cn.yjpt.bean.User;
import cn.yjpt.dao.UserDao;
import cn.yjpt.db.ConnectionFactory;
import cn.yjpt.db.DBClose;

public class UserDaoImpl implements UserDao {
	Connection connection = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	// 定义方法查询用户登录信息是否存在
	public User lookUser(User user) {
		// TODO Auto-generated method stub
		// 创建数据库的连接
		connection = ConnectionFactory.getConnection();
		// 定义一个用来查询用户名，密码，用户类型是否存在的SQL语句
		String sql = "select * from user where username=? and password=? and usertypes=?";
		try {
			// 创建PrepareStatement对象s
			pstat = connection.prepareStatement(sql);
			// pstat=connection.prepareStatement(sql);
			// 设置SQL语句的参数值
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getUsertypes());
			// 执行查询，返回结果集
			rs = pstat.executeQuery();
			// 如果结果集不为空，从结果集提取数据
			if (rs.next()) {
				// 用字段名作为参数取出id的值，封装为对象user的属性值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUsertypes(rs.getString("usertypes"));
				// 用字段名作为参数取出字段verify的值
				user.setVerify(rs.getString("verify"));
			} else {
				// 查询结果集为空
				user.setUsertypes("error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}

		return user;
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		String sql = "select * from user where username= '" + username + "'";
		try {
			pstat = connection.prepareStatement(sql);
			rs = pstat.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DBClose.close(pstat, con);
			DBClose.close(rs, pstat, connection);
		}

		return flag;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		connection = ConnectionFactory.getConnection();
		String sql = "insert into user(username,password,usertypes,verify) values (?,?,?,?) ";
		try {
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getUsertypes());
			pstat.setString(4, "1");
			// int i=pstat.executeUpdate();
			// rs=pstat.executeQuery();
			int i = pstat.executeUpdate();
			if (i > 0) {
				user = this.lookUser(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}

		return user;
	}

	public boolean updatePwd(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "update user set password=? where id=?";
			pstat = connection.prepareStatement(sql);
			pstat.setString(1, user.getPassword());
			pstat.setInt(2, user.getId());
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
				// this.updatePwd(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
			// e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}

	@Override
	public int doCount(DoPage dopage) {
		// TODO Auto-generated method stub
		// 定义count代表总记录数
		int count = 0;
		// 1.连接数据库
		connection = ConnectionFactory.getConnection();
		try {
			// 2.封装SQL语句
			pstat = connection.prepareStatement("select count(*) from user " + dopage.getSql());
			// 3.执行查询
			rs = pstat.executeQuery();
			// 4.处理结果
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

	// 定义方法获取总页数
	@Override
	public int doTatalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		// 定义m保存总记录数出一丝每页记录数的商
		int m = doCount(dopage) / dopage.getPageSize();
		if (doCount(dopage) % dopage.getPageSize() > 0) {
			totalPage = m + 1;
		} else {
			totalPage = m;
		}
		return totalPage;
	}

	// 定义方法查询某一页要显示的数据
	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
		// 声明List对象list保存查询到所有的记录封装的user对象
		List list = new ArrayList();
		// 1.获取和数据库连接
		connection = ConnectionFactory.getConnection();

		try {
			// 2.执行条件查询，定义PreparedStatement对象
			pstat = connection.prepareStatement("select * from user " + dopage.getSql() + "limit"
					+ (dopage.getNowPage() - 1) * dopage.getPageSize()+","+ dopage.getPageSize());
//			pstat=con.prepareStatement("select * from user "+dopage.getSql()+" limit "
//+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			// 3.执行查询
			rs = pstat.executeQuery();
			// 4.处理结果集
			while (rs.next()) {
				User user = new User();
				// 用查询的记录中id字段的值作为参数设置为user对象的id属性值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
				list.add(user);// 把封装好的user对象添加到列表中
			}
			dopage.setList(list);// 把userlist设置为dopage对象的成员属性值
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return dopage;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		User user = this.lookUserById(id);
		connection = ConnectionFactory.getConnection();

		try {
			if ("admin".equals(user.getUsertypes())) {
				pstat = connection.prepareStatement("delete from user where id=" + id);
				int i = pstat.executeUpdate();
				if (i > 0) {
					flag = true;
				}
			}
			if ("student".equals(user.getUsertypes())) {
				pstat = connection.prepareStatement("delete from user where id=" + id);
				int i = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from student where sid=" + id);
				int j = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from resume where sid=" + id);
				int k = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from recruitresume where sid=" + id);
				int m = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from message where id=" + id);
				int n = pstat.executeUpdate();
				if (i > 0) {
					flag = true;
				}
			}
			if ("company".equals(user.getUsertypes())) {
				pstat = connection.prepareStatement("delete from user where id=" + id);
				int i = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from company where cid=" + id);
				int j = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from recruitment where cid=" + id);
				int k = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from recruitresume where cid=" + id);
				int m = pstat.executeUpdate();
				pstat = connection.prepareStatement("delete from message where id=" + id);
				int n = pstat.executeUpdate();
				if (i > 0) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return flag;
	}

	// 禁用用戶
	@Override
	public boolean disableUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("update user set verify='1' where id=" + id);
			int n = pstat.executeUpdate();
			if (n != 0) {
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

	// 激活用戶
	@Override
	public boolean activeUser(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("update user set verify='2' where id=" + id);
			int n = pstat.executeUpdate();
			if (n != 0) {
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

	// 设置用户审核未通过
	@Override
	public boolean invalid(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("update user set verify='3' where id=" + id);
			int i = pstat.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return flag;
	}

	@Override
	public User lookUserById(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		connection = ConnectionFactory.getConnection();
		try {
			pstat = connection.prepareStatement("select * from user where id=" + id);
			rs = pstat.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstat, connection);
		}
		return user;
	}

}
