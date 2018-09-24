package com.gt.wide.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gt.wide.base.annotation.RequestMapping;
import com.gt.wide.dao.UserDaoLin;
import com.gt.wide.entity.Brand;
import com.gt.wide.entity.Kind;

public class searchService {
	
	@RequestMapping("/search.do")
	public String  search(HttpServletRequest request,
			HttpServletResponse response) {
		UserDaoLin uDao=new UserDaoLin();
		List<Brand> brands=uDao.findBrand();
		request.setAttribute("brands",brands);
		
		List<Kind> kinds=uDao.findKind();
		request.setAttribute("kinds", kinds);
		
		return "home/search";
	}
	
}
