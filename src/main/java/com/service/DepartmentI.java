package com.service;

import java.util.List;

import com.Dto.DepartmentDto;
import com.entity.Department;

public interface DepartmentI {
  
	DepartmentDto addDepartment(DepartmentDto departmentDto);
	
	List<Department> getAllDepartment();
}
