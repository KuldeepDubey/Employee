package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
