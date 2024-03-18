package com.Dto;

import com.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class EmployeeDto {

    private int empolyeeId;
	
	private String name;
	
	private String gender;
	
	private String city;
	
	private String department;

	public int getEmpolyeeId() {
		return empolyeeId;
	}

	public void setEmpolyeeId(int empolyeeId) {
		this.empolyeeId = empolyeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public EmployeeDto(int empolyeeId, String name, String gender, String city, String department) {
		super();
		this.empolyeeId = empolyeeId;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.department = department;
	}

	public EmployeeDto() {
		super();
		
	}
	
	
	
	
}
