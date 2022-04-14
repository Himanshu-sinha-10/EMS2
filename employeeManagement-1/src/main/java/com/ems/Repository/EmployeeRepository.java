package com.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

