package com.gt.wide.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.entity.User;
import com.gt.wide.mapper.UserDao;


/**
 * 注册业务：用于处理用户注册业务
 * 
 * @author 陈广坤
 *
 */

public class reg {
	/**
	 * 到注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/toReg.do")
	public String toReg() {
		return "person/reg";
	}

	/**
	 * 处理用户提交的注册信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/reg.do")
	public String UserReg(HttpServletRequest request) throws SQLException {
		System.out.println("reg.do方法...");
		UserDao dao = new UserDao();
		// 查询数据库，获取所有用户
		List<User> users = dao.findAllUsers();
		int id=users.size()+1;
		// 默认用户名
		String name = "user" + id;
		// 获取用户提交密码
		String password = request.getParameter("password");
		// 获取用户提交的确认密码
		String passwordConfirm = request.getParameter("passwordRepeat");
		//获取用户提交的手机号码
		String telephone = request.getParameter("phone");
		//获取用户提交的验证码
		String code=request.getParameter("code");
		boolean delFlag = false;
		// 获取系统当前时间，以固定格式，作为创建时间createTime和修改时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String createTime = sdf.format(date);
		String lastUpdate = createTime;
		//初次修改人员为注册用户
		String lastUpdater = name;
		//提交数据都不能为空
		boolean empty="".equals(telephone)||"".equals(password)
				||"".equals(passwordConfirm)||"".equals(code);
		
		if(empty){
			//提交数据不能为空
			request.setAttribute("reg_fail_haveEmpt", "提交信息不能为空");
			return "person/reg";
		}
		
		if (!password.equals(passwordConfirm)) {
			// 两次密码不一致，转发，重新注册
			request.setAttribute("reg_fail_pwd", "两次密码不一致");
			return "person/reg";
		}
		
		//检查验证码
		if(!"1234".equals(code)){
			// 验证码不正确，转发，重新注册
			request.setAttribute("reg_fail_code", "验证码错误");
			return "person/reg";
		}
		
		for (User u : users) {
			// 根据数据库查询出的用户，遍历，对比该手机号码是否已经注册
			String  phone = u.getTelephone();
			if (phone.equals(telephone)) {
				request.setAttribute("reg_fail_phone", "该号码已经注册过");
				return "person/reg";
			}
		}
		User user = new User();
		user.setId(id);
		user.setUserName(name);
		user.setPwd(password);
		user.setDelFlag(delFlag);
		user.setCreateTime(createTime);
		user.setLastUpdate(lastUpdate);
		user.setLastUpdater(lastUpdater);
		user.setTelephone(telephone);
		dao.addUser(user);
		dao.addUserInfo(user);
		System.out.println("注册成功");
		return "redirect:reg_success.do";
	}
	
	@RequestMapping("/reg_success.do")
	public String toReg_success() {
		return "person/reg_success";
	}

}
