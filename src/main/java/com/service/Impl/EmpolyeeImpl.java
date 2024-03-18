package com.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.EmployeeDto;
import com.Repository.DepartmentRepo;
import com.Repository.EmpolyeeRepo;
import com.entity.Department;
import com.entity.Employee;
import com.service.EmployeeI;

@Service
public class EmpolyeeImpl implements EmployeeI {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmpolyeeRepo empolyeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto empolDto) {
		Employee map = this.modelMapper.map(empolDto, Employee.class);
		Department department = this.departmentRepo.findByDepertmentName(empolDto.getDepartment());
		System.out.println(department.getDepertmentName());
		map.setDepartment(department);
		Employee save = this.empolyeeRepo.save(map);
		EmployeeDto map2 = this.modelMapper.map(save, EmployeeDto.class);
		// TODO Auto-generated method stub
		return map2;
	}

	@Override
	public EmployeeDto getEmpolyee(int empId) {
		
		Employee employee = this.empolyeeRepo.findById(empId).get();
		EmployeeDto map = this.modelMapper.map(employee, EmployeeDto.class);
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public List<Employee> getAllEmpolyee(int departmentId) {
		List<Employee> findAll = this.empolyeeRepo.findAll();
		List<Employee> list = findAll.stream().filter(a->a.getDepartment().getDepertmentId()==departmentId).collect(Collectors.toList());
		return list;
	}

}
