package com.cg.dao;

public class JdbcDao implements IDao{

	public JdbcDao() {
		System.out.println("jdbc dao constructor");
	}
	@Override
	public String getEmployee() {
		
		return "jdbc";
	}

}
