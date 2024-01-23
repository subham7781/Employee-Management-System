package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.webapp.entity.Employee;
import com.webapp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	

	@GetMapping("/")
	public String getAllReg(org.springframework.ui.Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String Employee(@ModelAttribute("employee") Employee employee, org.springframework.ui.Model model) {
		employeeService.saveEmployee(employee);
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		return "index";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);	
		return "update_employee";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id,Model model) {
		employeeService.deleteEmployeeById(id);
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		return "index";
	}
}
