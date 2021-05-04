 package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.service.Service;

public class ClientA {
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		System.out.println("main satrts");
		Service ser = ctx.getBean("myser", Service.class);
		System.out.println(ser.viewEmployee()); 
		
		System.out.println("demand second time");
		Service ser2 = ctx.getBean("myser", Service.class);
		System.out.println(ser2.viewEmployee()); 
	}
}
