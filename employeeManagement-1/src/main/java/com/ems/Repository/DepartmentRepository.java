package com.ems.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}