package com.ems.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ems.ServicesInterface.EmployeeServiceInterface;
import com.ems.Entity.Employee;
import com.ems.Repository.EmployeeRepository;


@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee emp)
	{
		Employee e = employeeRepository.save(emp);
		return emp;
	}
	
	public void deleteEmployee(int id)
	{
		employeeRepository.deleteById(id);
		
	}
	
	
	//Test not done
	public Employee updateEmployee(Employee emp)
	{
		employeeRepository.save(emp);
		return emp;
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> e = employeeRepository.findById(id);
		if(e.isPresent())
			return e.get();
		else return null;
	}
	
	public List<Employee> getEmployeeByPagination(int recordsPerPage,  int offset)
	{
		
		Pageable page = PageRequest.of(offset,recordsPerPage );
		List<Employee> employeeList = employeeRepository.findAll(page).getContent();
		return employeeList;
		
	}
	
	public long getEmployeeCount() {
		long count = employeeRepository.count();
		return count;
	}

}

