package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.SuccessMessage;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

@RestController
public class DeleteEmpController {

	@Autowired
	private IEmpService service;
	
	@DeleteMapping("deleteemployee/{eid}")
	public SuccessMessage deleteEmployee(@PathVariable("eid") int eid) throws EmpNotFoundException{
		
		eid=service.deleteEmployee(eid);
		
		return new SuccessMessage("Employee deleted with employee id: "+eid);
	}
}
