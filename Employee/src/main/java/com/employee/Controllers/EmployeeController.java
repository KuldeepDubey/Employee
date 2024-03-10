package com.employee.Controllers;

import java.util.List;

import com.employee.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employee.Service.EmployeeService;
import com.employee.payloads.EmployeeDto;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// To get from page
	@GetMapping("/")
	public String home() {
		return "index";
	}


	// To save employee details
	@PostMapping("/submit")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
		EmployeeDto createdEmployeeDto = this.employeeService.createEmplyee(employeeDto);
		return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
	}



	//To get particular employee detail
	@GetMapping("display/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer employeeId){
		
		return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
	}


	// To get all employees detail
	@GetMapping("/displayall")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
	}
}
