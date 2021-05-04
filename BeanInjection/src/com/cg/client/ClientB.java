package com.cg.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cg.service.Service;

public class ClientB {

	static BeanFactory fac = null;
	
	static {
		Resource res = new ClassPathResource("beans.xml");
		fac = new XmlBeanFactory(res);
	}
	public static void main(String[] args) {
		System.out.println("main satrts");
		Service ser = fac.getBean("myser", Service.class);
		System.out.println(ser.viewEmployee());
		System.out.println("demand second time");
		Service ser2 = fac.getBean("myser", Service.class);
		System.out.println(ser2.viewEmployee());
	}

}
