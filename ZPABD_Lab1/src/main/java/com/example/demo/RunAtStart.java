package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAtStart {
	private final EmployeeRopository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Autowired
	public RunAtStart(EmployeeRopository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	
	@PostConstruct
	public void runAtStart() {
		Department department = new Department();
        department.setDeptName("Sprzedaż");
        departmentRepository.save(department);
        
        Department department2 = new Department();
        department2.setDeptName("Marketing");
        departmentRepository.save(department2);
		
		Employee employee = new Employee();
		employee.setFristName("Wojciech");
		employee.setLastName("Jurek");
		employee.setSalary(new BigDecimal("7000"));
		employee.setEmploymentDate(LocalDate.of(2020,  01,  1));
		employee.setDepartment(department);
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setFristName("Stefan");
		employee2.setLastName("Kowalski");
		employee2.setSalary(new BigDecimal("6000"));
		employee2.setEmploymentDate(LocalDate.of(2020,  02,  3));
		employee2.setDepartment(department2);
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee();
		employee3.setFristName("Jan");
		employee3.setLastName("Kowalski");
		employee3.setSalary(new BigDecimal("5000"));
		employee3.setEmploymentDate(LocalDate.of(2020,  03,  2));
		employee3.setDepartment(department2);
		employeeRepository.save(employee3);
		
		
		Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
		for(Employee e:em) {
			System.out.println(e);
		}
	
	}
}