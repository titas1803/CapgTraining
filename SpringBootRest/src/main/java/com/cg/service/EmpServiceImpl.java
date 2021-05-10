package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

@Service("myser")
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpDao empdao;
	@Autowired
	private IDeptDao deptdao;

	@Override
	@Transactional
	public Integer addEmployee(EmpDto empdto) throws DeptException {
		// TODO Auto-generated method stub

		Emp emp = new Emp();
//		emp.setEmpId(getNextIdForEmployee());
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = deptdao.findByDeptName(empdto.getDeptName());
		if (dept == null)
			throw new DeptException("No Department Found");
		emp.setDept(dept);
		Emp persistedEmp = empdao.save(emp);
		return persistedEmp.getEmpId();
	}

	@Override
	public List<Emp> viewEmployee() throws EmpNotFoundException {
		// TODO Auto-generated method stub
		List<Emp> lst = empdao.findAll();
		if (lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		return lst;
	}

	@Override
	public Emp viewEmployee(int eid) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		Optional<Emp> optemp = empdao.findById(eid);
		if (!optemp.isPresent())
			throw new EmpNotFoundException("No Employee Found for Id " + eid);
		return optemp.get();
	}

	@Override
	public List<Emp> viewEmployee(String deptName) throws EmpNotFoundException {
		List<Emp> lst = empdao.viewEmployee(deptName);
		if (lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		return lst;
	}

	@Override
	public List<Emp> viewEmployee(LocalDate startdoj, LocalDate enddoj) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		List<Emp> lst=empdao.viewEmployee(startdoj, enddoj);
		if(lst.isEmpty())
			throw new EmpNotFoundException();
		lst.sort((e1,e2)-> e1.getEmpDoj().compareTo(e2.getEmpDoj()));
		return lst;
	}

	@Override
	@Transactional
	public Integer editEmployee(EmpDto empdto) throws DeptException, EmpNotFoundException {
		// TODO Auto-generated method stub
		Integer eid=empdto.getEmpId();
		Optional<Emp> optemp = empdao.findById(eid);
		if (!optemp.isPresent())
			throw new EmpNotFoundException("No Employee Found for Id " + eid);
		Emp emp=optemp.get();
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = deptdao.findByDeptName(empdto.getDeptName());
		if (dept == null)
			throw new DeptException("No Department Found");
		emp.setDept(dept);
		return empdao.save(emp).getEmpId();		
	}
	
	@Override
	@Transactional
	public Integer deleteEmployee(int eid) throws EmpNotFoundException{
		Optional<Emp> optemp=empdao.findById(eid);
		if (!optemp.isPresent())
			throw new EmpNotFoundException("No Employee Found for Id " + eid);
		empdao.deleteById(eid);
		return optemp.get().getEmpId();
	}
}
