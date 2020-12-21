package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	// LIKE %?1
	@Query("SELECT e FROM Employee e WHERE e.lastName = ?1 and e.department.deptID = ?2")
	Iterable<Employee> findAllWhereLastNameAndDeptId(String lastName, Long i);
}
