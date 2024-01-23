package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
