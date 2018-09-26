package com.gt.wide.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.bean.Information;
import com.gt.wide.util.DBUtil;

public class InformationDao {
	//��ѯ������Ϣ
	/**
	 * select user_id,nickname,gender,birthday,email,create_time,last_update_time,
	 * last_update_person from wide_user_info where user_id=1;
	 * �����û�id��user_id��ѯ�û���Ϣ����Ϣ
	 * @param userId
	 * @return ������򷵻�Information����û����null
	 */
	public Information selectInformation(int userId) {
		System.out.println("seletInfo����");
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		Information information=null;
		try {
			conn=DBUtil.getConn();
			String sql="select id, user_id,nickname,gender,birthday,email,create_time,"
					+ "last_update_time,last_update_person from wide_user_info where user_id=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1, userId);
			rs=stat.executeQuery();
			if(rs.next()){
				//�õ����ݿ��û���Ϣ
				int id=rs.getInt("id");
				int uId=rs.getInt("user_id");
				String nickName=rs.getString("nickname");
				String gender=rs.getString("gender");
				String  birthday=rs.getString("birthday");
				String email=rs.getString("email");
				String  createTime=rs.getString("create_time");
				String  lastUpdate=rs.getString("last_update_time");
				String lastUpdater=rs.getString("last_update_person");
				//����������Ϣ����
				 information=new Information();
				//Ϊ������Ϣ����ֵ
				 information.setId(id);
				information.setUserId(uId);
				information.setNickName(nickName);
				information.setGender(gender);
				information.setBirthday(birthday);
				information.setEmail(email);
				information.setCreateTime(createTime);
				information.setLastUpdate(lastUpdate);
				information.setLastUpdater(lastUpdater);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return information;
	}
	
	//�����û���Ϣ
	
	public void  updateInformation(int userId,String nickname,
			String gender,String birthday,String email) {
		
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtil.getConn();
			String sql="update wide_user_info set nickname=? ,"
					+ "gender=? ,birthday=?, email=? where user_id=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1, nickname);
			stat.setString(2, gender);
			stat.setString(3, birthday);
			stat.setString(4, email);
			stat.setInt(5, userId);
			stat.executeUpdate();
			System.out.println("�������");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stat, rs);
		}
	}
	
	
}
