package cn.yjpt.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
//	定义方法关闭结果集
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
//	定义方法关闭Statement对象
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
//	定义方法关闭Connection对象
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
//定义公有方法，关闭用来添加，删除，修改数据库的连接资源
	public static void close(Statement stat,Connection con) {
		close(stat);
		close(con);
	}
//定义公有方法，关闭用来查询数据库的连接
	public static void close(ResultSet rs,Statement stat,Connection con) {
		close(rs);
		close(stat);
		close(con);
	}

}
