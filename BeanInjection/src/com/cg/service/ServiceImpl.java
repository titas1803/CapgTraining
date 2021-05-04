package com.cg.service;

import com.cg.dao.IDao;

public class ServiceImpl implements Service{

	private IDao dao;
	
	public ServiceImpl() {
		System.out.println("service constructor fires");
		
	}
	
	public ServiceImpl(IDao dao) {
		System.out.println("service one arg constructor fires and inject dependency");
		this.dao = dao;
	}
	//it is used by IOC to inject the dependency
	public void setDao(IDao dao) {
		System.out.println("injecting dao dependency");
		this.dao = dao;
	}

	@Override
	public String viewEmployee() {
		
		return dao.getEmployee();
	}

}
