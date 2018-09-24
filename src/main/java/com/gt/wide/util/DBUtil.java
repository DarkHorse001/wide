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
		
			//创建数据源对象
			basicDataSource=new BasicDataSource();
			//设置数据库连接信息

			Properties prop=new Properties();//获取属性对象
			//获取文件输入流，通过反射获得
			InputStream ips=DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			try {
			prop.load(ips);//加载文件到属性对象中
												//获取配置文件中的数据
			basicDataSource.setDriverClassName(prop.getProperty("driver").trim());
			basicDataSource.setUrl(prop.getProperty("url").trim());
			basicDataSource.setUsername(prop.getProperty("username").trim());
			basicDataSource.setPassword(prop.getProperty("password").trim());
			//设置连接池连接策略
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
				//归还之前把自动提交打开
				conn.setAutoCommit(true);
				conn.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
