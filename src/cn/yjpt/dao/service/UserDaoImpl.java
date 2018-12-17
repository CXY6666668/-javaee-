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

	// ���巽����ѯ�û���¼��Ϣ�Ƿ����
	public User lookUser(User user) {
		// TODO Auto-generated method stub
		// �������ݿ������
		connection = ConnectionFactory.getConnection();
		// ����һ��������ѯ�û��������룬�û������Ƿ���ڵ�SQL���
		String sql = "select * from user where username=? and password=? and usertypes=?";
		try {
			// ����PrepareStatement����s
			pstat = connection.prepareStatement(sql);
			// pstat=connection.prepareStatement(sql);
			// ����SQL���Ĳ���ֵ
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getUsertypes());
			// ִ�в�ѯ�����ؽ����
			rs = pstat.executeQuery();
			// ����������Ϊ�գ��ӽ������ȡ����
			if (rs.next()) {
				// ���ֶ�����Ϊ����ȡ��id��ֵ����װΪ����user������ֵ
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUsertypes(rs.getString("usertypes"));
				// ���ֶ�����Ϊ����ȡ���ֶ�verify��ֵ
				user.setVerify(rs.getString("verify"));
			} else {
				// ��ѯ�����Ϊ��
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
			System.out.println("����ʧ��");
			// e.printStackTrace();
		} finally {
			DBClose.close(pstat, connection);
		}
		return flag;
	}

	@Override
	public int doCount(DoPage dopage) {
		// TODO Auto-generated method stub
		// ����count�����ܼ�¼��
		int count = 0;
		// 1.�������ݿ�
		connection = ConnectionFactory.getConnection();
		try {
			// 2.��װSQL���
			pstat = connection.prepareStatement("select count(*) from user " + dopage.getSql());
			// 3.ִ�в�ѯ
			rs = pstat.executeQuery();
			// 4.������
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

	// ���巽����ȡ��ҳ��
	@Override
	public int doTatalPage(DoPage dopage) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		// ����m�����ܼ�¼����һ˿ÿҳ��¼������
		int m = doCount(dopage) / dopage.getPageSize();
		if (doCount(dopage) % dopage.getPageSize() > 0) {
			totalPage = m + 1;
		} else {
			totalPage = m;
		}
		return totalPage;
	}

	// ���巽����ѯĳһҳҪ��ʾ������
	@Override
	public DoPage doFindAll(DoPage dopage) {
		// TODO Auto-generated method stub
		// ����List����list�����ѯ�����еļ�¼��װ��user����
		List list = new ArrayList();
		// 1.��ȡ�����ݿ�����
		connection = ConnectionFactory.getConnection();

		try {
			// 2.ִ��������ѯ������PreparedStatement����
			pstat = connection.prepareStatement("select * from user " + dopage.getSql() + "limit"
					+ (dopage.getNowPage() - 1) * dopage.getPageSize()+","+ dopage.getPageSize());
//			pstat=con.prepareStatement("select * from user "+dopage.getSql()+" limit "
//+(dopage.getNowPage()-1)*dopage.getPageSize()+","+dopage.getPageSize());
			// 3.ִ�в�ѯ
			rs = pstat.executeQuery();
			// 4.��������
			while (rs.next()) {
				User user = new User();
				// �ò�ѯ�ļ�¼��id�ֶε�ֵ��Ϊ��������Ϊuser�����id����ֵ
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertypes(rs.getString("usertypes"));
				user.setVerify(rs.getString("verify"));
				list.add(user);// �ѷ�װ�õ�user������ӵ��б���
			}
			dopage.setList(list);// ��userlist����Ϊdopage����ĳ�Ա����ֵ
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

	// �����Ñ�
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

	// �����Ñ�
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

	// �����û����δͨ��
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
