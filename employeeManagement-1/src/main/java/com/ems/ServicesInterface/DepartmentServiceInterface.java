package com.ems.ServicesInterface;

import java.util.List;

import com.ems.Entity.Department;

public interface DepartmentServiceInterface {

	public void addDepartment(String dName);
	public List<Department> getAllDepartments();
	public long getAllDepartmentsCount();
	public boolean deleteDepartmentById(int id);
	public List<Department> getDepartmentByPagination(int recordsPerPage,  int offset);
	public long getDepartmentCount();
	
}