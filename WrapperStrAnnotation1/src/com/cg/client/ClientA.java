package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.service.ICurrencyService;

public class ClientA {
	
	static ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
	
	public static void main(String[] args) {
		System.out.println("Main Starts");
		ICurrencyService  ser =ctx.getBean("myservice",ICurrencyService.class);
		System.out.println(ser.convertToINR(300));
		System.out.println(ser.currentState());
		
	}

}