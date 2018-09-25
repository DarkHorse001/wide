package com.gt.wide.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.entity.Information;
import com.gt.wide.entity.User;
import com.gt.wide.mapper.InformationDao;
import com.gt.wide.mapper.UserDao;
/**
 * 个人信息类，查询和修改个人信息
 * @author 陈广坤
 *
 */
public class info {

	//到个人信息页面，即查询
	@RequestMapping("/toInfo.do")
	public String  toInformation(HttpSession session) {
		System.out.println("toInfo方法。。");
		//获取session绑定的id
		Object uids=session.getAttribute("id");
		Integer uid=(Integer) uids;
		//如果session绑定为null，则是未登录，重定向到登录
		if(uids==null){
			return "redirect:toLogin.do";
		}else{
			//已登录，则查询数据库的用户信息表
			int userId=uid;
			try {
				//绑定用户表
				UserDao userDao=new UserDao();
				User user=userDao.findUserByName(userId);
				session.setAttribute("user", user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//绑定用户详情表
			InformationDao infoDao=new InformationDao();
			Information userInfo=infoDao.selectInformation(userId);
			session.setAttribute("userInfo", userInfo);
			System.out.println("已登录");
			return "person/information";
		}
	}
	
	/**
	 * 更新用户数据
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateInfo.do")
	public String updateInfo(HttpServletRequest request,HttpSession session) {
		String nickName=request.getParameter("nickName");
		String userName=request.getParameter("userName");
		String gender=request.getParameter("radio10");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		
		Object uid=session.getAttribute("id");
		int userId=(Integer)uid;
		InformationDao infoDao=new InformationDao();
		Information userInfo=infoDao.selectInformation(userId);
		System.out.println("birthday:"+userInfo.getBirthday());
		if(!"2018-01-01 00:00:00".equals(userInfo.getBirthday())){
			birthday=userInfo.getBirthday();
		}
		
		infoDao.updateInformation(userId, nickName, gender, birthday, email);
		UserDao userDao=new UserDao();
		userDao.updateUserName(userId, userName);
		session.setAttribute("update", "修改成功");
		return "redirect:toInfo.do";
	}
}
