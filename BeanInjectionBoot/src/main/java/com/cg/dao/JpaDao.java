package com.cg.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("jpadao")
@Lazy
public class JpaDao implements IDao {

	public JpaDao() {
		System.out.println("jpa dao constructor");
	}
	@Override
	public String getEmployee() {
		
		return "jpa";
	}

}
