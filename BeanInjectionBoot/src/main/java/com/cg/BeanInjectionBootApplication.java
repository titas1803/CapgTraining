package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.service.IService;

@SpringBootApplication
public class BeanInjectionBootApplication implements CommandLineRunner {
	
	@Autowired
	private IService service;
	public static void main(String[] args) {
		SpringApplication.run(BeanInjectionBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("main starts");
		System.out.println(service.viewEmployee());
		
	}

}
