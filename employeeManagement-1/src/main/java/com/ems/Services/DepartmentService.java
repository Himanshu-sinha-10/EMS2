package com.ems.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ems.ServicesInterface.DepartmentServiceInterface;
import com.ems.Entity.Department;

import com.ems.Repository.DepartmentRepository;


@Service
public class DepartmentService implements DepartmentServiceInterface {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public void addDepartment(String dName)
	{
		Department d = new Department(dName);
		departmentRepository.save(d);
		
	}
	
	public List<Department> getAllDepartments()
	{
		
		List<Department> list = departmentRepository.findAll();
		return list;
	}
	
	
	
	public long getAllDepartmentsCount() {
		return departmentRepository.count();
	}
	
	
	//for invalid id or id not present inplement exception handling
	public boolean deleteDepartmentById(int id)
	{
		departmentRepository.deleteById(id);
		return true;
	}
	
	
	public List<Department> getDepartmentByPagination(int recordsPerPage,  int offset)
	{
		
		Pageable page = PageRequest.of(offset,recordsPerPage);
		List<Department> departmentList = departmentRepository.findAll(page).getContent();
		return departmentList;
		
	}
	
	public long getDepartmentCount() {
		long count = departmentRepository.count();
		return count;
	}
}

