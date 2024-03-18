package com.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empolyeeId;
	
	private String name;
	
	private String gender;
	
	private String city;
	
	@ManyToOne
	private Department department;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(int empolyeeId, String name, String gender, String city, Department department) {
		super();
		this.empolyeeId = empolyeeId;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.department = department;
	}

	public Employee() {
		super();
		
	}
	
	

}
