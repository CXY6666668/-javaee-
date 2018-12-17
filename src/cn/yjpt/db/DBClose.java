package cn.yjpt.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
//	���巽���رս����
	private static void close(ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//	���巽���ر�Statement����
	private static void  close(Statement stat) {
		if(stat!=null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
//	���巽���ر�Connection����
	private static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//���幫�з������ر�������ӣ�ɾ�����޸����ݿ��������Դ
	public static void close(Statement stat,Connection con) {
		close(stat);
		close(con);
	}
//���幫�з������ر�������ѯ���ݿ������
	public static void close(ResultSet rs,Statement stat,Connection con) {
		close(rs);
		close(stat);
		close(con);
	}

}
