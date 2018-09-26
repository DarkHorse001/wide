package com.gt.wide.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.bean.User;
import com.gt.wide.mapper.UserDao;


/**
 * ע��ҵ�����ڴ����û�ע��ҵ��
 * 
 * @author �¹���
 *
 */

public class reg {
	/**
	 * ��ע��ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/toReg.do")
	public String toReg() {
		return "person/reg";
	}

	/**
	 * �����û��ύ��ע����Ϣ
	 * 
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/reg.do")
	public String UserReg(HttpServletRequest request) throws SQLException {
		System.out.println("reg.do����...");
		UserDao dao = new UserDao();
		// ��ѯ���ݿ⣬��ȡ�����û�
		List<User> users = dao.findAllUsers();
		int id=users.size()+1;
		// Ĭ���û���
		String name = "user" + id;
		// ��ȡ�û��ύ����
		String password = request.getParameter("password");
		// ��ȡ�û��ύ��ȷ������
		String passwordConfirm = request.getParameter("passwordRepeat");
		//��ȡ�û��ύ���ֻ�����
		String telephone = request.getParameter("phone");
		//��ȡ�û��ύ����֤��
		String code=request.getParameter("code");
		boolean delFlag = false;
		// ��ȡϵͳ��ǰʱ�䣬�Թ̶���ʽ����Ϊ����ʱ��createTime���޸�ʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String createTime = sdf.format(date);
		String lastUpdate = createTime;
		//�����޸���ԱΪע���û�
		String lastUpdater = name;
		//�ύ���ݶ�����Ϊ��
		boolean empty="".equals(telephone)||"".equals(password)
				||"".equals(passwordConfirm)||"".equals(code);
		
		if(empty){
			//�ύ���ݲ���Ϊ��
			request.setAttribute("reg_fail_haveEmpt", "�ύ��Ϣ����Ϊ��");
			return "person/reg";
		}
		
		if (!password.equals(passwordConfirm)) {
			// �������벻һ�£�ת��������ע��
			request.setAttribute("reg_fail_pwd", "�������벻һ��");
			return "person/reg";
		}
		
		//�����֤��
		if(!"1234".equals(code)){
			// ��֤�벻��ȷ��ת��������ע��
			request.setAttribute("reg_fail_code", "��֤�����");
			return "person/reg";
		}
		
		for (User u : users) {
			// �������ݿ��ѯ�����û����������Աȸ��ֻ������Ƿ��Ѿ�ע��
			String  phone = u.getTelephone();
			if (phone.equals(telephone)) {
				request.setAttribute("reg_fail_phone", "�ú����Ѿ�ע���");
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
		System.out.println("ע��ɹ�");
		return "redirect:reg_success.do";
	}
	
	@RequestMapping("/reg_success.do")
	public String toReg_success() {
		return "person/reg_success";
	}

}
