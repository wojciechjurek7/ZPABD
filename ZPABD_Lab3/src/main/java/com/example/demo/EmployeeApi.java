package com.example.demo;

import java.util.Optional;

import javax.annotation.PostConstruct;

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
@RequestMapping("/api/employees")
public class EmployeeApi {

	private EmployeeManager employeeManager;

	@Autowired
	public EmployeeApi(EmployeeManager employeeManager) {
		super();
		this.employeeManager = employeeManager;
	}
	
	@GetMapping("/all")
	public Iterable<Employee> getAll() {
		return employeeManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Employee> getById(@RequestParam Long id) {
		return employeeManager.findById(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeManager.save(employee);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		employeeManager.delete(id);
	}
	
	@PutMapping("/update")
	public Employee deleteById(@RequestParam Long id, @RequestBody Employee employee) {
		Employee employeeToUpdate = employeeManager.findById(id).get();
		employeeToUpdate = employee;
		return employeeManager.save(employeeToUpdate);
	}
	
}
