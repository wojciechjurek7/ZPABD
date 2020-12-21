package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentManager {

	private final DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentManager(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	
	public Optional<Department> findById(Long id) {
		return departmentRepository.findById(id);
	}
	
	public Iterable<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	public Department save(Department employee) {
		return departmentRepository.save(employee);
	}
	
	public void delete(Long id) {
		departmentRepository.deleteById(id);
	}
}
