package com.gt.wide.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class testConnect {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stat=null;
		boolean flag=false;
		try {
			conn = DBUtil.getConn();
			//String sql="insert into t_date values(null,?,?)";
			//String sql="insert into wide_users values(2,?,?,?,?,?,?,?)";
//			stat =conn.prepareStatement(sql);
			//���ʺŻ���Ŀ��ֵ
			//stat.setString(1, "2018-09-13 20:24");
			//ִ��SQL
			//stat.setBoolean(2, flag);
			
//			stat.executeUpdate();
//			System.out.println("�������ݳɹ�");
//			stat.setString(1, "user01");
//			stat.setString(2, "1234");
//			stat.setBoolean(3,flag);
//			stat.setString(4,  "2018-09-13");
//			stat.setString(5,  "2018-09-13");
//			stat.setString(6, "user01");
//			stat.setString(7, "18218131836");
			
			String sql="update wide_users set name=? where user_id=?";
			stat =conn.prepareStatement(sql);
			stat.setString(1, "user01");
			stat.setInt(2, 1);
			System.out.println("׼���������...");
			stat.executeUpdate();
			System.out.println("������ݳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stat, rs);
		}


	}

}
