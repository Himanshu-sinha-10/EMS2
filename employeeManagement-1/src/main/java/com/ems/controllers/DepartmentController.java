package com.ems.controllers;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Entity.Department;

import com.ems.Services.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping(path = "/departments")
	public ResponseEntity<List<Department>> getDepartments()
	{
		List<Department> l = departmentService.getAllDepartments();
		return new ResponseEntity<List<Department>>(l,HttpStatus.OK);
	}
	
	@PostMapping(path = "/department/add")
	public void addDepartment(@RequestParam String deptName)
	{
		departmentService.addDepartment(deptName);
		
	}
	
	@GetMapping(path = "/department/pagination")
	public ResponseEntity<List<Department>> getDepartmentByPagination(@RequestParam int recordsPerPage, @RequestParam int offset){
		List<Department> l = departmentService.getDepartmentByPagination(recordsPerPage, offset);
		return new ResponseEntity<List<Department>>(l,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/department/count")
	public ResponseEntity<Long> getDepartmentCount()
	{
		long count = departmentService.getDepartmentCount();
		return new ResponseEntity<Long>(count,HttpStatus.OK);
		
	}
	

}
