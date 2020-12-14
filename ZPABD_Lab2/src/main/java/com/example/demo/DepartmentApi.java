package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentApi {
	private DepartmentManager departmentManager;
	private EmployeeManager employeeManager;

	@Autowired
	public DepartmentApi(DepartmentManager departmentManager, EmployeeManager employeeManager) {
		super();
		this.departmentManager = departmentManager;
		this.employeeManager = employeeManager;
	}
	
	@GetMapping("/all")
	public Iterable<Department> getAll() {
		return departmentManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Department> getById(@RequestParam Long id) {
		return departmentManager.findById(id);
	}
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department department) {
		return departmentManager.save(department);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		departmentManager.delete(id);
	}
	
	@PutMapping("/update")
	public Department deleteById(@RequestParam Long id, @RequestBody Department department) {
		Department departmentToUpdate = departmentManager.findById(id).get();
		departmentToUpdate = department;
		return departmentManager.save(departmentToUpdate);
	}
	
	@PutMapping("/addToDept")
	public Employee addEmployeeToDepartment(@RequestParam Long deptId, @RequestParam Long empId) {
		Department department = departmentManager.findById(deptId).get();
		Employee employee = employeeManager.findById(empId).get();
		employee.setDepartment(department);
		return employeeManager.save(employee);
	}

}
