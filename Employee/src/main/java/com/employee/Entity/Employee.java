package com.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name",nullable = false,length = 100)
	private String employeeName;
	
	
	private String employeeEmail;
	
	
	private String employeeLocation;
	

}
