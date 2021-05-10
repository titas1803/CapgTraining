package com.cg;

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
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestAddEmployee {

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
		Emp persistedemp=new Emp(1001,"abcd",50000.0,LocalDate.of(2019,07,25));
		when(empdao.save(any(Emp.class))).thenReturn(persistedemp);
	}
	
	@Test
	@DisplayName(value="testAddEmployee for dept hr 1")
	public void testAddEmployee1() throws DeptException
	{
		EmpDto empdto=new EmpDto(1001,"abcd",65000.0,LocalDate.of(2020, 12,30),"hr");
		assertNotNull(service.addEmployee(empdto));
	}
	
	@Test
	@DisplayName(value="testAddEmployee for dept hr 2")
	public void testAddEmployee2() throws DeptException
	{
		EmpDto empdto=new EmpDto(1001,"abcd",65000.0,LocalDate.of(2020, 12,30),"hr");
		assertTrue(service.addEmployee(empdto)==1001);
	}
	
	@Test
	@DisplayName(value="testAddEmployee for dept aaa")
	public void testAddEmployee3() throws DeptException
	{
		EmpDto empdto=new EmpDto("abcd",65000.0,LocalDate.of(2020, 12,30),"aaa");
		assertThrows(DeptException.class, ()->service.addEmployee(empdto));
	}
	
}
