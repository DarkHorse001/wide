package com.gt.wide.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.bean.User;
import com.gt.wide.mapper.UserDao;

/**
 * ��¼ҵ�񣺴����û���¼ҵ���߼�
 * @author �¹���
 *
 */
public class login {
	/**
	 * ����¼ҳ��
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
		// ��ѯ���ݿ⣬��ȡ�����û�
		UserDao dao=new UserDao();
		List<User> users = dao.findAllUsers();
		
		//��ȡ�û��ύ���û������ֻ���
		String name=request.getParameter("user");
		//��ȡ�û��ύ������
		String pwd=request.getParameter("password");
		//�ύ���ݶ�����Ϊ��
		boolean haveEmpt="".equals(name)||"".equals(pwd);
		
		if(haveEmpt){
			//�ύ����Ϊ�գ�ת��
			request.setAttribute("login_fail_haveEmpt", "�ύ����Ϣ����Ϊ��");
			return "login/login";
		}
		
		for(User u:users){
			//��ѯ�Ƿ����û������ֻ���
			String uname=u.getUserName();
			String phone=u.getTelephone();
			String password=u.getPwd();
			int  id=u.getId();
			//���û������ֻ���ʱ�ٱȶ�����
			if(uname.equals(name)||phone.equals(name)){
				if(password.equals(pwd)){
					//����ƥ��,��¼�ɹ�
					session.setAttribute("id", id);
					return "redirect:toHome.do";
				}else{
					//������󣬷��ص�¼
					request.setAttribute("login_fail_pwdError", "�������");
					return "login/login";
				}
			}
		}
		request.setAttribute("login_fail_noUser", "�û������ֻ��Ŵ���");
		return "login/login";
		
	}
	
}
