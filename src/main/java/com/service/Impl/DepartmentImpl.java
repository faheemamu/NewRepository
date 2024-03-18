package com.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.DepartmentDto;
import com.Repository.DepartmentRepo;
import com.entity.Department;
import com.service.DepartmentI;

@Service
public class DepartmentImpl implements DepartmentI {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		Department map = this.modelMapper.map(departmentDto, Department.class);
		Department save = this.departmentRepo.save(map);
		DepartmentDto map2 = this.modelMapper.map(save, DepartmentDto.class);
		// TODO Auto-generated method stub
		return map2;
	}

	@Override
	public List<Department> getAllDepartment() {
		
		List<Department> findAll = this.departmentRepo.findAll();
		// TODO Auto-generated method stub
		return findAll;
	}

}
