package com.example.demo;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptID;
	private String deptName;

	@JsonManagedReference
	@OneToMany(mappedBy = "department") //, cascade = CascadeType.ALL, orphanRemoval = true
    Set<Employee> employees; //@JoinColumn(name = "department")
    
    public Long getDeptID() {
		return deptID;
	}
	public void setDeptID(Long deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
    
    
	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + "]";
	}
}
