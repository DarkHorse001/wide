package com.gt.wide.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.entity.Information;
import com.gt.wide.util.DBUtil;

public class InformationDao {
	//查询个人信息
	/**
	 * select user_id,nickname,gender,birthday,email,create_time,last_update_time,
	 * last_update_person from wide_user_info where user_id=1;
	 * 根据用户id，user_id查询用户信息表信息
	 * @param userId
	 * @return 如果有则返回Information对象，没有则null
	 */
	public Information selectInformation(int userId) {
		System.out.println("seletInfo方法");
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
				//拿到数据库用户信息
				int id=rs.getInt("id");
				int uId=rs.getInt("user_id");
				String nickName=rs.getString("nickname");
				String gender=rs.getString("gender");
				String  birthday=rs.getString("birthday");
				String email=rs.getString("email");
				String  createTime=rs.getString("create_time");
				String  lastUpdate=rs.getString("last_update_time");
				String lastUpdater=rs.getString("last_update_person");
				//创建个人信息对象
				 information=new Information();
				//为个人信息对象赋值
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
	
	//更新用户信息
	
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
			System.out.println("更新完成");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stat, rs);
		}
	}
	
	
}
