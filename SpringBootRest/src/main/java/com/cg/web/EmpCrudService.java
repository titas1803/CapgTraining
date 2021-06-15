package com.cg.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.SuccessMessage;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.ValidateEmpException;
import com.cg.service.IEmpService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmpCrudService {

	@Autowired
	private IEmpService service;
	
	@PostMapping("addemployee")
//	@RequestMapping(value="addemployee", method=RequestMethod.POST)
	public SuccessMessage addEmployee(@Valid @RequestBody EmpDto empdto, BindingResult br) throws DeptException, ValidateEmpException
	{
//		System.out.println("AddEmployee");
		if(br.hasErrors()) {
			throw new ValidateEmpException(br.getFieldErrors());
		}
		int eid=service.addEmployee(empdto);
		return new SuccessMessage("your generated Id is "+eid);
	}
}
