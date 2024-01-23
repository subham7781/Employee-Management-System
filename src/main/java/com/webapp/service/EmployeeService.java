package com.webapp.service;

import java.util.List;

import com.webapp.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
