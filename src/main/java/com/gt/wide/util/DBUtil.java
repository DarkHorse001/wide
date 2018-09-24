package com.gt.wide.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil {
	private static BasicDataSource basicDataSource;
	static {
		
			//��������Դ����
			basicDataSource=new BasicDataSource();
			//�������ݿ�������Ϣ

			Properties prop=new Properties();//��ȡ���Զ���
			//��ȡ�ļ���������ͨ��������
			InputStream ips=DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			try {
			prop.load(ips);//�����ļ������Զ�����
												//��ȡ�����ļ��е�����
			basicDataSource.setDriverClassName(prop.getProperty("driver").trim());
			basicDataSource.setUrl(prop.getProperty("url").trim());
			basicDataSource.setUsername(prop.getProperty("username").trim());
			basicDataSource.setPassword(prop.getProperty("password").trim());
			//�������ӳ����Ӳ���
			int InitialSize=Integer.parseInt(prop.getProperty("InitialSize").trim());
			int MaxActive=Integer.parseInt(prop.getProperty("MaxActive").trim());
			basicDataSource.setInitialSize(InitialSize);
			basicDataSource.setMaxActive(MaxActive);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() throws SQLException{

		return basicDataSource.getConnection();

	}

	public static void close(Connection conn,Statement stat,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(conn!=null){
				//�黹֮ǰ���Զ��ύ��
				conn.setAutoCommit(true);
				conn.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
