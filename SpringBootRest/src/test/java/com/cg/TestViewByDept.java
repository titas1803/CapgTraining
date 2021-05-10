package com.cg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestViewByDept {
	
	@Mock
	private IEmpDao dao;
	
	@InjectMocks
	private IEmpService service=new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		List<Emp> lst=new ArrayList<>();
		lst.add(new Emp(1001,"abcd", 60000.0, LocalDate.of(2016, 06, 05)));
		lst.add(new Emp(1002,"efgh", 65000.0, LocalDate.of(2018, 12, 05)));
		List<Emp> lst2=new ArrayList<>();
		when(dao.viewEmployee("hr")).thenReturn(lst);
		when(dao.viewEmployee("aaa")).thenReturn(lst2);
	}

	@Test
	@DisplayName(value="testViewByDept for hr")
	public void testViewByDept1() throws EmpNotFoundException {
		assertTrue(service.viewEmployee("hr").size()>0);
	}
	
	@Test
	@DisplayName(value = "testViewByDept for aaa")
	public void testViewByDept2() {
		
		assertThrows(EmpNotFoundException.class, ()->service.viewEmployee("aaa"));
	}
}
