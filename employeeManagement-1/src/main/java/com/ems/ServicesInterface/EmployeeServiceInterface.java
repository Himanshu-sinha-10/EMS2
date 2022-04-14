package com.ems.ServicesInterface;


import java.util.List;

import com.ems.Entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee emp);
	public void deleteEmployee(int id);
	public Employee updateEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeeByPagination(int recordsPerPage,  int offset);
	public long getEmployeeCount();
}
