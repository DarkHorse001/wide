package com.gt.wide.service;


import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;

public class address {
	
	@RequestMapping("/toAddress.do")
	public String  toInformation(HttpSession session) {
		System.out.println("toAddress��������");
		//��ȡsession�󶨵�id
		Object uids=session.getAttribute("id");
		Integer uid=(Integer) uids;
		//���session��Ϊnull������δ��¼���ض��򵽵�¼
		if(uids==null){
			return "redirect:toLogin.do";
		}else{
			//�ѵ�¼�����ѯ���ݿ���û���Ϣ��
			int userId=uid;
			
			//���û������
			
			return "person/address";
		}
	}
}
