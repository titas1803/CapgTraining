package com.cg.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.SuccessMessage;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.exceptions.ValidateEmpException;
import com.cg.service.IEmpService;

@RestController
public class EmpEditController {
	
	@Autowired
	private IEmpService service;
	
	@PutMapping("editemployee")
	public SuccessMessage editEmployee(@Valid @RequestBody EmpDto empdto, BindingResult br) throws ValidateEmpException,EmpNotFoundException,DeptException
	{
		if(br.hasErrors())
			throw new ValidateEmpException(br.getFieldErrors());
		Integer eid=service.editEmployee(empdto);
		return new SuccessMessage("Employee updated with employee id: "+eid);
	}
}
