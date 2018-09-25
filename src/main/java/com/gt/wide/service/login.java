package com.gt.wide.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.entity.User;
import com.gt.wide.mapper.UserDao;

/**
 * 登录业务：处理用户登录业务逻辑
 * @author 陈广坤
 *
 */
public class login {
	/**
	 * 到登录页面
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String  toLogin() {
		return "login/login";
	}
	
	@RequestMapping("/toHome.do")
	public String toHome(){
		return "home/home";
	}
	
	@RequestMapping("/login.do")
	public String  UserLogin(HttpServletRequest request,HttpSession session) throws SQLException {
		System.out.println("");
		// 查询数据库，获取所有用户
		UserDao dao=new UserDao();
		List<User> users = dao.findAllUsers();
		
		//获取用户提交的用户名或手机号
		String name=request.getParameter("user");
		//获取用户提交的密码
		String pwd=request.getParameter("password");
		//提交数据都不能为空
		boolean haveEmpt="".equals(name)||"".equals(pwd);
		
		if(haveEmpt){
			//提交数据为空，转发
			request.setAttribute("login_fail_haveEmpt", "提交的信息不能为空");
			return "login/login";
		}
		
		for(User u:users){
			//查询是否有用户名或手机号
			String uname=u.getUserName();
			String phone=u.getTelephone();
			String password=u.getPwd();
			int  id=u.getId();
			//含用户名或手机号时再比对密码
			if(uname.equals(name)||phone.equals(name)){
				if(password.equals(pwd)){
					//密码匹配,登录成功
					session.setAttribute("id", id);
					return "redirect:toHome.do";
				}else{
					//密码错误，返回登录
					request.setAttribute("login_fail_pwdError", "密码错误");
					return "login/login";
				}
			}
		}
		request.setAttribute("login_fail_noUser", "用户名或手机号错误");
		return "login/login";
		
	}
	
}
