package com.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entity.Employee;
import com.webapp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		Employee employee=null;
		if (findById.isPresent()) {
			employee = findById.get();
		} else {
			throw new RuntimeException("Employee not found  for id ::" +id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);		
	}

}
