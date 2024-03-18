package com.service;

import java.util.List;

import com.Dto.EmployeeDto;
import com.entity.Employee;

public interface EmployeeI {

	EmployeeDto addEmployee(EmployeeDto empolDto);
	
	EmployeeDto getEmpolyee(int empId);
	
	List<Employee> getAllEmpolyee(int departmentId);
}
