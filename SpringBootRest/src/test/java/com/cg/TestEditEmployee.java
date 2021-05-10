package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestEditEmployee {
	
	@Mock
	private IEmpDao empdao;
	@Mock
	private IDeptDao deptdao;
	@InjectMocks
	private IEmpService service= new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		when(deptdao.findByDeptName("hr")).thenReturn(new Dept());
		when(deptdao.findByDeptName("aaa")).thenReturn(null);
		Optional<Emp> optemp1= Optional.of(new Emp(1001,"abcd",50000.0,LocalDate.of(2019,07,25)));
		Optional<Emp> optEmp2=Optional.empty();
		when(empdao.findById(1001)).thenReturn(optemp1);
		when(empdao.findById(1002)).thenReturn(optEmp2);
		when(empdao.save(any(Emp.class))).thenReturn(optemp1.get());
	}
	
	@Test
	@DisplayName(value="testEditEmployee for dept hr 1")
	public void testEditEmployee1() throws DeptException, EmpNotFoundException
	{
		EmpDto empdto=new EmpDto(1001,"abcd",65000.0,LocalDate.of(2020, 12,30),"hr");
//		assertNotNull(service.editEmployee(empdto));
		assertEquals(1001,service.editEmployee(empdto) );
	}
	
	@Test
	@DisplayName(value="testEditEmployee for eid 1002")
	public void testEditEmployee3() throws DeptException, EmpNotFoundException
	{
		EmpDto empdto=new EmpDto(1002,"abcd",65000.0,LocalDate.of(2020, 12,30),"hr");
		assertThrows(EmpNotFoundException.class, ()->service.editEmployee(empdto));
	}
	
	@Test
	@DisplayName(value="testEditEmployee for dept aaa")
	public void testAddEmployee2() throws DeptException
	{
		EmpDto empdto=new EmpDto(1001,"abcd",65000.0,LocalDate.of(2020, 12,30),"aaa");
		assertThrows(DeptException.class, ()->service.editEmployee(empdto));
	}
}
