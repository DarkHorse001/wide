package com.gt.wide.base.controller;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gt.wide.base.common.Handler;
import com.gt.wide.base.common.HandlerMapping;




/**
 * �����������������������Ȼ������HandlerMapping �����õ��ö�Ӧ��
 * service���µ�Controller�����������������ٸ��ݴ��������صĴ���ṹ����ͼ��������
 * ��Ӧ��jsp;
 * @author �¹���
 */
public class DispatcherServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	/**
	 *��init�������棬ͨ����ȡsmatrmvc.xml�ļ�����ô�����������
	 *Ȼ�󽫴�����ʵ����������������������ʵ������HandlerMapping������
	 *
	 */
	public void init() throws ServletException {
		
		try {
			String  xmlName=getServletConfig().getInitParameter("location");
			InputStream in=getClass().getClassLoader().getResourceAsStream(xmlName);
			System.out.println("xmlName:"+xmlName);
			SAXReader reader=new SAXReader();
			Document doc=reader.read(in);
			Element root=doc.getRootElement();
			List<Element> elements=root.elements("service");
			System.out.println("elements:"+elements);
			//���serviceʵ���ļ���
			List beans=new ArrayList();
			for(Element e: elements){
				 String className=e.attributeValue("class");
				 Object bean=Class.forName(className).newInstance();
				 beans.add(bean);
			}
			System.out.println("beans:"+beans);
			//��serviceʵ�����Ͻ���HandlerMapping����
			handlerMapping=new HandlerMapping();
			handlerMapping.process(beans);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//���������Դ·��
		String uri=request.getRequestURI();
		System.out.println("uri:"+uri);
		//���Ӧ��·��
		String contextPath=getServletContext().getContextPath();
		System.out.println("contextPath:"+contextPath);
		//��ȡ����·��
		String path=uri.substring(contextPath.length());
		System.out.println("path:"+path);
		Handler handler=handlerMapping.getHandler(path);
		Method mh=handler.getMh();
		Object obj=handler.getObj();
		Object returnVal=null;
		try {
			//��ȡ�����Ĳ������ͣ��������
			Class[] types=mh.getParameterTypes();
			Object[] params=new Object[types.length];
			if(types.length>0){
				for(int i=0;i<types.length;i++){
					if(types[i]==HttpServletRequest.class){
						params[i]=request;
					}else if(types[i]==HttpServletResponse.class){
						params[i] =response;
					}
				}
				returnVal=mh.invoke(obj, params);
			}else{
				returnVal=mh.invoke(obj);
			}
			String viewName=returnVal.toString();
			System.out.println("viewName:"+viewName);
			if(viewName.startsWith("redirect:")){
				//�ض���
				String redirectPath=contextPath+"/"+viewName.substring("redirect:".length());
				response.sendRedirect(redirectPath);
			}else{
				//ת��
				String jspPath=viewName+".jsp";
				request.getRequestDispatcher(jspPath).forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}