package com.employee.Service;

import java.util.List;

import com.employee.payloads.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmplyee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Integer employeeId);
	
	List<EmployeeDto> getAllEmployee();

}
