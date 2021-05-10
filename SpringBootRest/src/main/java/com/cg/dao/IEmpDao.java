package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Emp;

@Repository
public interface IEmpDao extends JpaRepository<Emp, Integer> {
	
	@Query("from Emp e inner join e.dept d where d.deptName=:dname")
	public List<Emp> viewEmployee(@Param("dname") String deptName);
	
	@Query("from Emp e where e.empDoj>=:startdoj and e.empDoj<=:enddoj")
	public List<Emp> viewEmployee(@Param("startdoj") LocalDate startDate, @Param("enddoj") LocalDate endDate);
	
//	@Query("delete from Emp e where  e.empid=:eid")
//	public void deleteEmpolyee(@Param("eid") Integer eid);
}
