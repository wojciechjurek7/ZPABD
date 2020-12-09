package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRopository extends CrudRepository<Employee, Long> {
	@Query("SELECT e FROM Employee e WHERE e.lastName LIKE %?1")
	Iterable<Employee> findAllWhereName(String lastName);
}
