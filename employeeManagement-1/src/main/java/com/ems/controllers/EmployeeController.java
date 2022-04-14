

package com.ems.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Entity.Employee;

import com.ems.Services.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping(path = "/welcome")
	public String welcomeMsg()
	{
		return "Welcome to employee management system";
	}
	
	@GetMapping(path = "employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "employee/delete")
	public ResponseEntity<Integer> deleteEmployee(@RequestParam("id") int id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	
	@PostMapping(path = "employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		Employee e = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/pagination")
	public ResponseEntity<List<Employee>> getEmployeesByPagination(@RequestParam int recordsPerPage, @RequestParam int offset){
		List<Employee> l = employeeService.getEmployeeByPagination(recordsPerPage, offset);
		return new ResponseEntity<List<Employee>>(l,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/employee/count")
	public ResponseEntity<Long> getEmployeeCount()
	{
		long count = employeeService.getEmployeeCount();
		return new ResponseEntity<Long>(count,HttpStatus.OK);
		
	}
}
