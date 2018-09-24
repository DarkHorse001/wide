package com.gt.wide.base.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gt.wide.base.annotation.RequestMapping;



public class HandlerMapping {
	private Map<String , Handler> handlerMap=new HashMap<String, Handler>();
	/**
	 * ���ڽ�������·���봦�����Ķ�Ӧ��ϵ
	 * �÷�������������ʵ�����ϣ�����ÿ��������ʵ��������Java�������
	 * ��ȡ���ڷ���ǰ��@RequestMappingע���ص�·����Ϣ��Ȼ����·����Ϣ��Ϊkey��
	 * �Դ�����ʵ��������������������Ϊvalue���������Ӧ��ϵ��ӵ�handlerMap����
	 * @param beans
	 */
	public void process(List beans) {
		for(Object bean:beans){
			//��ȡClass����
			Class cls=bean.getClass();
			//��ȡ���з���
			Method[] methods=cls.getDeclaredMethods();
			System.out.println("method.length:"+methods.length);
			for(Method mh:methods){
				//���@RequestMappingע��
				RequestMapping rm=mh.getDeclaredAnnotation(RequestMapping.class);
				//���@RequestMappingע�������ֵ��������·��
				String path=rm.value();
				handlerMap.put(path, new Handler(mh,bean));
			}
		}
		System.out.println("handlerMapping:"+handlerMap);
	}
	
	/**
	 * ��������·�������ش�����ʵ������������������ķ�װ����Handler����
	 * @param path
	 * @return
	 */
	public Handler getHandler(String path){
		return handlerMap.get(path);
	}
}
