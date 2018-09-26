package com.gt.wide.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.bean.Information;
import com.gt.wide.bean.User;
import com.gt.wide.mapper.InformationDao;
import com.gt.wide.mapper.UserDao;
/**
 * ������Ϣ�࣬��ѯ���޸ĸ�����Ϣ
 * @author �¹���
 *
 */
public class info {

	//��������Ϣҳ�棬����ѯ
	@RequestMapping("/toInfo.do")
	public String  toInformation(HttpSession session) {
		System.out.println("toInfo��������");
		//��ȡsession�󶨵�id
		Object uids=session.getAttribute("id");
		Integer uid=(Integer) uids;
		//���session��Ϊnull������δ��¼���ض��򵽵�¼
		if(uids==null){
			return "redirect:toLogin.do";
		}else{
			//�ѵ�¼�����ѯ���ݿ���û���Ϣ��
			int userId=uid;
			try {
				//���û���
				UserDao userDao=new UserDao();
				User user=userDao.findUserByName(userId);
				session.setAttribute("user", user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//���û������
			InformationDao infoDao=new InformationDao();
			Information userInfo=infoDao.selectInformation(userId);
			session.setAttribute("userInfo", userInfo);
			System.out.println("�ѵ�¼");
			return "person/information";
		}
	}
	
	/**
	 * �����û�����
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
		session.setAttribute("update", "�޸ĳɹ�");
		return "redirect:toInfo.do";
	}
}
