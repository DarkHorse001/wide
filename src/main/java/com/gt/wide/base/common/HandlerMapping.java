package com.gt.wide.base.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gt.wide.base.annotation.RequestMapping;



public class HandlerMapping {
	private Map<String , Handler> handlerMap=new HashMap<String, Handler>();
	/**
	 * 用于建立请求路径与处理器的对应关系
	 * 该方法遍历处理器实例集合，对与每个处理器实例，利用Java反射机制
	 * 读取加在方法前的@RequestMapping注解重的路径信息，然后以路径信息作为key，
	 * 以处理器实例及处理器方法对象作为value，将这个对应关系添加到handlerMap里面
	 * @param beans
	 */
	public void process(List beans) {
		for(Object bean:beans){
			//获取Class对象
			Class cls=bean.getClass();
			//获取所有方法
			Method[] methods=cls.getDeclaredMethods();
			System.out.println("method.length:"+methods.length);
			for(Method mh:methods){
				//获得@RequestMapping注解
				RequestMapping rm=mh.getDeclaredAnnotation(RequestMapping.class);
				//获得@RequestMapping注解的属性值，即请求路径
				String path=rm.value();
				handlerMap.put(path, new Handler(mh,bean));
			}
		}
		System.out.println("handlerMapping:"+handlerMap);
	}
	
	/**
	 * 根据请求路径，返回处理器实例及处理器方法对象的封装（即Handler对象）
	 * @param path
	 * @return
	 */
	public Handler getHandler(String path){
		return handlerMap.get(path);
	}
}
