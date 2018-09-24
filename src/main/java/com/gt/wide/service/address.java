package com.gt.wide.service;


import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;

public class address {
	
	@RequestMapping("/toAddress.do")
	public String  toInformation(HttpSession session) {
		System.out.println("toAddress方法。。");
		//获取session绑定的id
		Object uids=session.getAttribute("id");
		Integer uid=(Integer) uids;
		//如果session绑定为null，则是未登录，重定向到登录
		if(uids==null){
			return "redirect:toLogin.do";
		}else{
			//已登录，则查询数据库的用户信息表
			int userId=uid;
			
			//绑定用户详情表
			
			return "person/address";
		}
	}
}
