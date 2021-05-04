package com.cg.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("jdbcdao")
@Lazy
public class JdbcDao implements IDao{

	public JdbcDao() {
		System.out.println("jdbc dao constructor");
	}
	@Override
	public String getEmployee() {
		
		return "jdbc";
	}

}
