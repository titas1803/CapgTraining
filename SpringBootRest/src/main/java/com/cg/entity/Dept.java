package com.cg.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cg_dept")
public class Dept {
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer deptid;
	
	@Column(name="dept_name", length=25)
	private String deptName;
	
	@Transient
	private Set<Emp> employees;
	
	@OneToMany(mappedBy = "dept")
	@JsonIgnore
	public Set<Emp> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getDeptid()+" "+this.getDeptName(); 
	}
	
}
