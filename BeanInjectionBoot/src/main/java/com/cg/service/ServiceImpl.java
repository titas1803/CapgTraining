package com.cg.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cg.dao.IDao;
@Service("myser")
public class ServiceImpl implements IService{

	private IDao dao;
	
	public ServiceImpl() {
		System.out.println("service constructor fires");
		
	}
	
	public ServiceImpl(IDao dao) {
		System.out.println("service one arg constructor fires and inject dependency");
		this.dao = dao;
	}
	//it is used by IOC to inject the dependency
//	@Autowired
//	@Qualifier("jpadao")
//	@Resource(name="${mydao}")
	@Value("#{${mydao}}")
	public void setDao(IDao dao) {
		System.out.println("injecting dao dependency");
		this.dao = dao;
	}

	@Override
	public String viewEmployee() {
		
		return dao.getEmployee();
	}

}
