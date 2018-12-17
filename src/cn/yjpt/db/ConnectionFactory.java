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

	// ����˽�еĹ��췽������ֹ�������ⴴ������
	private ConnectionFactory() {
	}

	// ���徲̬��ʼ���飬���÷�����ȡjdbc.properties�����ļ�����
	static {
		getProperties();
	}

	// ���巽������ȡ�����ļ��е�����
	private static void getProperties() {
		// TODO Auto-generated method stub
		// ��ȡ��ǰ���е��̶߳���
		Thread curThread = Thread.currentThread();
		// ��ȡ��ǰ�̵߳��������
		ClassLoader loader = curThread.getContextClassLoader();
		// ��ȡ�����ļ���������
		InputStream inStream = loader.getResourceAsStream("jdbc.properties");
		// �������������ļ����ݵĶ���
		Properties properties = new Properties();
		// �������ļ��е����ݱ��浽properties������
		try {
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��properties �����ж�ȡ4�����Ե�ֵ����ֵ��4����Ա����
		DRIVER = properties.getProperty("driver");
		URL = properties.getProperty("url");
		USERNAME = properties.getProperty("username");
		PASSWORD = properties.getProperty("password");

	}

	// ���徲̬��������ȡ�����ݿ������
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// ������������
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// ��ȡ�����ݿ�����Ӷ���
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
