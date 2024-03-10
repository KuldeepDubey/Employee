package com.employee.Service.Impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;
import com.employee.exceptions.ResourceNotFoundException;
import com.employee.payloads.EmployeeDto;
import com.employee.repository.EmployeeRepo;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto createEmplyee(EmployeeDto employeeDto) {
		
		Employee employee = this.dtoToEmployee(employeeDto);
		Employee savedEmployee = this.employeeRepo.save(employee);
		return this.employeeToDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee", "Id",employeeId));
		return this.employeeToDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = this.employeeRepo.findAll();
		List<EmployeeDto> employeeDtos = employees.stream().map(employee->employeeToDto(employee)).collect(Collectors.toList());
		return employeeDtos;
	}
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		return employee;
	}
	
	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
		
		return employeeDto;
	}
	

}
