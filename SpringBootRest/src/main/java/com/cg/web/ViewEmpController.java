package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

@RestController		
public class ViewEmpController {

	@Autowired
	private IEmpService service;
	@GetMapping("viewbydept/{dname}")
	public List<Emp> viewEmployee(@PathVariable("dname") String dept) throws EmpNotFoundException{
		return service.viewEmployee(dept);
	}
	
	@GetMapping("viewbyid/{eid}")
	public Emp viewEmployeebyId(@PathVariable("eid") int empId) throws EmpNotFoundException {
		return service.viewEmployee(empId);
	}
}
