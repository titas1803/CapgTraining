package com.cg.dao;

public class JpaDao implements IDao {

	public JpaDao() {
		System.out.println("jpa dao constructor");
	}
	@Override
	public String getEmployee() {
		
		return "jpa";
	}

}
