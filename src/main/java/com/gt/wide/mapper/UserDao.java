package com.gt.wide.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gt.wide.entity.User;
import com.gt.wide.util.DBUtil;


public class UserDao {
	//封装插入数据
		/**
		 * 添加用户到数据库,即注册
		 * @param user
		 */
		public void addUser(User user) {
			System.out.println("addUser方法...");
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs=null;
			int id=user.getId();
			String uname=user.getUserName();
			String pwd=user.getPwd();
			boolean delFlag=user.isDelFlag();
			String  createTime=user.getCreateTime();
			String  lastUpdate=user.getLastUpdate();
			String lastUpdater=user.getLastUpdater();
			String   telephone=user.getTelephone();
			try {
				conn = DBUtil.getConn();
				String sql="insert into wide_users values(?,?,?,?,?,?,?,?)";
				stat=conn.prepareStatement(sql);
				System.out.println(user);
				stat.setInt(1, id);
				stat.setString(2, uname);
				stat.setString(3, pwd);
				stat.setBoolean(4,delFlag);
				stat.setString(5,  createTime);
				stat.setString(6,  lastUpdate);
				stat.setString(7, lastUpdater);
				stat.setString(8, telephone);
				System.out.println("准备添加数据...");
				stat.executeUpdate();
				System.out.println("添加数据成功");
				
				
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				DBUtil.close(conn, stat, rs);
			}

		}
		
		public void addUserInfo(User user) {
			System.out.println("addUserInfo方法...");
			System.out.println(user);
			Connection conn = null;
			PreparedStatement stat = null;
			ResultSet rs=null;
			int id=user.getId();
			String nickname=user.getUserName();
			String  createTime=user.getCreateTime();
			String  lastUpdate=user.getLastUpdate();
			String lastUpdater=user.getLastUpdater();
			try {
				conn = DBUtil.getConn();
				String sql="insert into wide_user_info values(null,?,?,?,?,?,?,?,?)";
				stat=conn.prepareStatement(sql);
				stat.setInt(1, id);//user_id
				stat.setString(2, nickname);//nickname
				stat.setString(3, "m");//gender
				stat.setString(4,"2018-01-01");//birthday
				stat.setString(5,  "");//email
				stat.setString(6,  createTime);//crea_tetime
				stat.setString(7, lastUpdate);//last_update_time
				stat.setString(8, lastUpdater);//last_update_person
				
				System.out.println("准备添加数据2...");
				stat.executeUpdate();
				System.out.println("添加数据成功2");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				DBUtil.close(conn, stat, rs);
			}

		}
		
		/**
		 * 修改用户名
		 * @param uid 对应已登录id
		 * @param name 新修改用户名
		 */
		public void updateUserName(int uid,String name ) {
			Connection conn=null;
			PreparedStatement stat=null;
			ResultSet rs=null;
			try {
				conn=DBUtil.getConn();
				String sql="update wide_users set name=? where user_id=? ";
				stat=conn.prepareStatement(sql);
				stat.setString(1, name);
				stat.setInt(2,uid);
				stat.executeUpdate();
				System.out.println("更新完成");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, stat, rs);
			}
		}
		
		
		/**
		 * 将所有用户信息从数据库中查询出来
		 * @return
		 * @throws SQLException 
		 */
		public List<User> findAllUsers() throws SQLException{
			List<User> users=new ArrayList<User>();
			Connection conn=null;
			PreparedStatement stat=null;
			ResultSet rs=null;
			try {
				conn=DBUtil.getConn();
				String sql="select user_id,name,password,del_flag,create_time,last_update_time,"
						+ "last_update_person,telephone from wide_users";
				stat=conn.prepareStatement(sql);
				rs=stat.executeQuery();
				while(rs.next()){
					int id=rs.getInt("user_id");
					String name=rs.getString("name");
					String pwd=rs.getString("password");
					boolean delFlag=rs.getBoolean("del_flag");
					String  createTime=rs.getString("create_time");
					String  lastUpdate=rs.getString("last_update_time");
					String lastUpdater=rs.getString("last_update_person");
					String  telephone=rs.getString("telephone");
					
					User user=new User();
					user.setId(id);
					user.setUserName(name);
					user.setPwd(pwd);
					user.setDelFlag(delFlag);
					user.setCreateTime(createTime);
					user.setLastUpdate(lastUpdate);
					user.setLastUpdater(lastUpdater);
					user.setTelephone(telephone);;
					
					users.add(user);
				}
				
				
			} catch (SQLException e) {
				// 
				
				//将异常抛出，交调用者处理
				throw new RuntimeException(e);
			}finally {
				DBUtil.close(conn, stat, rs);
			}
			return users;
		}
		
		/**
		 * 通过用户名查找用户
		 * @param name
		 * @return
		 * @throws SQLException
		 */
		public User findUserByName(int uid) throws SQLException{
			Connection conn=null;
			PreparedStatement stat=null;
			ResultSet rs=null;
			User user=null;
			try {
				conn=DBUtil.getConn();
				String sql="select user_id,name,password,del_flag,create_time,last_update_time,"
						+ "last_update_person,telephone from wide_users where user_id=?";
				stat=conn.prepareStatement(sql);
				stat.setInt(1, uid);
				rs=stat.executeQuery();
				if(rs.next()){
					String username=rs.getString("name");
					String pwd=rs.getString("password");
					boolean delFlag=rs.getBoolean("del_flag");
					String  createTime=rs.getString("create_time");
					String  lastUpdate=rs.getString("last_update_time");
					String lastUpdater=rs.getString("last_update_person");
					String  telephone=rs.getString("telephone");
					
					 user=new User();
					user.setId(uid);
					user.setUserName(username);
					user.setPwd(pwd);
					user.setDelFlag(delFlag);
					user.setCreateTime(createTime);
					user.setLastUpdate(lastUpdate);
					user.setLastUpdater(lastUpdater);
					user.setTelephone(telephone);;
				}
				
				
			} catch (SQLException e) {
				// 
				
				//将异常抛出，交调用者处理
				throw new RuntimeException(e);
			}finally {
				DBUtil.close(conn, stat, rs);
			}
			return user;
		}
		
}
