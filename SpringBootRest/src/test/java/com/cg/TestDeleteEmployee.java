package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestDeleteEmployee {

	@Mock
	private IEmpDao dao;
	
	@InjectMocks
	private IEmpService service=new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		Optional<Emp> optemp1= Optional.of(new Emp(1001,"abcd",50000.0,LocalDate.of(2019,07,25)));
		Optional<Emp> optEmp2=Optional.empty();
		when(dao.findById(1001)).thenReturn(optemp1);
		when(dao.findById(1002)).thenReturn(optEmp2);
	}
	
	@Test
	@DisplayName(value="testDeleteEmployee1 1001")
	public void testDeleteEmployee1() throws EmpNotFoundException {
		assertEquals(1001, service.deleteEmployee(1001));
	}
	
	@Test
	@DisplayName(value="testDeleteEmployee2 1002")
	public void testViewById2() throws EmpNotFoundException {
		assertThrows(EmpNotFoundException.class,()->service.deleteEmployee(1002));
	}
	
}
