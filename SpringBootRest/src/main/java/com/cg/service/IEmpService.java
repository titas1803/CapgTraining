package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dto.EmpDto;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

public interface IEmpService {
	public Integer addEmployee(EmpDto empdto) throws DeptException;
	
	public List<Emp> viewEmployee() throws EmpNotFoundException;
	
	public Emp viewEmployee(int eid) throws EmpNotFoundException;
	
	public List<Emp> viewEmployee(String deptName) throws EmpNotFoundException;
	
	public List<Emp> viewEmployee(LocalDate startdoj, LocalDate enddoj) throws EmpNotFoundException;
	
	public Integer editEmployee(EmpDto empdto) throws DeptException,EmpNotFoundException;
	
	public Integer deleteEmployee(int eid) throws EmpNotFoundException;
}
