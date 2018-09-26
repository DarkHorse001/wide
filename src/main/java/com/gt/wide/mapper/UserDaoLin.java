package com.gt.wide.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gt.wide.bean.Brand;
import com.gt.wide.bean.Directory;
import com.gt.wide.bean.Kind;
import com.gt.wide.util.DBUtil;


public class UserDaoLin {
//	/**
//	 * 查找所有的种类
//	 * @return 返回一个所有种类集合
//	 */
//	public List<Kind> findKind(){
//		List<Kind> kinds=new ArrayList<Kind>();
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		
//		try {
//			conn=DBUtil.getConn();
//			String sql="select directory_id,kind_name from wide_kind "
//					+ "where directory_id in(1,10,15,25,33);";
//			ps=conn.prepareStatement(sql);
//			rs=ps.executeQuery();
//			while(rs.next()){
//				int directory_id=rs.getInt("directory_id");
//				String kind_name=rs.getString("kind_name");
//				Kind kind=new Kind();
//				kind.setDirectory_id(directory_id);
//				kind.setKind_name(kind_name);
//				kinds.add(kind);
//			}
//		} catch (Exception e) {
//			//记录日记
//			e.printStackTrace();
//			//将异常抛出，交给调用者来处理
//			throw new RuntimeException(e);
//		} finally {
//			DBUtil.close(conn, ps, rs);
//		}
//		return kinds;
//	}
//	/**
//	 * 查找所有的品牌
//	 * @return 返回一个所有品牌的集合
//	 */
//	public List<Brand> findBrand(){
//		List<Brand> brands=new ArrayList<Brand>();
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		
//		try {
//			conn=DBUtil.getConn();
//			String sql="select directory_id,brand_name from wide_brand "
//					+ "where directory_id in(1,10,15,25,33);";
//			ps=conn.prepareStatement(sql);
//			rs=ps.executeQuery();
//			while(rs.next()){
//				int directory_id=rs.getInt("directory_id");
//				String brand_name=rs.getString("brand_name");
//				Brand brand=new Brand();
//				brand.setDirectory_id(directory_id);
//				brand.setBrand_name(brand_name);
//				brands.add(brand);
//			}
//		} catch (Exception e) {
//			//记录日记
//			e.printStackTrace();
//			//将异常抛出，交给调用者来处理
//			throw new RuntimeException(e);
//		} finally {
//			DBUtil.close(conn, ps, rs);
//		}
//		return brands;
//	}
//		
//	/**
//	 * 将所有用户信息从数据库中查询出来。
//	 * @return
//	 */
//	public List<Directory> findAll(){
//		List<Directory> directorys=new ArrayList<Directory>();
//		
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		
//		try {
//			conn=DBUtil.getConn();
//			String sql="select directory_id,pid,dname from wide_directory where pid = 0";
//			ps=conn.prepareStatement(sql);
//			rs=ps.executeQuery();
//			while(rs.next()){
//				int directory_id=rs.getInt("directory_id");
//				int pid=rs.getInt("pid");
//				String dname=rs.getString("dname");
////				String ddescription=rs.getString("ddescription");
////				Date create_time=rs.getDate("create_time");
////				Date last_update_time=rs.getDate("last_update_time");
////				int last_update_person=rs.getInt("last_update_person");
//				
//				Directory directory=new Directory();
//				directory.setDirectory_id(directory_id);
//				directory.setPid(pid);
//				directory.setDname(dname);
////				directory.setDdescription(ddescription);
////				directory.setCreate_time(create_time);
////				directory.setLast_update_time(last_update_time);
////				directory.setLast_update_person(last_update_person);
//				directorys.add(directory);
//				
//			}
//			
//			
//		} catch (Exception e) {
//			//记录日记
//			e.printStackTrace();
//			//将异常抛出，交给调用者来处理
//			throw new RuntimeException(e);
//		} finally {
//			DBUtil.close(conn, ps, rs);
//		}
//		return directorys;
//	}

}

