package com.employee.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {



	private Integer employeeId;
	
	@NotEmpty
	@Size(min=4,message = "Name should not be less then 4 characters !!")
	private String employeeName;
	
	
	@Email(message = "Your email address is not valid !!")
	private String employeeEmail;
	

	@NotEmpty
	private String employeeLocation;

}
