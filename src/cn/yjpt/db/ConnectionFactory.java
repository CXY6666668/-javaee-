package cn.yjpt.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String DRIVER = "";
	private static String URL = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";

	// 定义私有的构造方法，禁止从类体外创建对象
	private ConnectionFactory() {
	}

	// 定义静态初始化块，调用方法读取jdbc.properties属性文件内容
	static {
		getProperties();
	}

	// 定义方法，获取属性文件中的数据
	private static void getProperties() {
		// TODO Auto-generated method stub
		// 获取当前运行的线程对象
		Thread curThread = Thread.currentThread();
		// 获取当前线程的类加载器
		ClassLoader loader = curThread.getContextClassLoader();
		// 获取属性文件的输入流
		InputStream inStream = loader.getResourceAsStream("jdbc.properties");
		// 创建保存属性文件内容的对象
		Properties properties = new Properties();
		// 把属性文件中的内容保存到properties对象中
		try {
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 从properties 对象中读取4个属性的值，赋值给4个成员变量
		DRIVER = properties.getProperty("driver");
		URL = properties.getProperty("url");
		USERNAME = properties.getProperty("username");
		PASSWORD = properties.getProperty("password");

	}

	// 定义静态方法，获取和数据库的连接
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// 加载驱动程序
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// 获取和数据库的连接对象
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
