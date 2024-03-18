package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depertmentId;
	
	private String depertmentName;

	public int getDepertmentId() {
		return depertmentId;
	}

	public void setDepertmentId(int depertmentId) {
		this.depertmentId = depertmentId;
	}

	public String getDepertmentName() {
		return depertmentName;
	}

	public void setDepertmentName(String depertmentName) {
		this.depertmentName = depertmentName;
	}

	public Department(int depertmentId, String depertmentName) {
		super();
		this.depertmentId = depertmentId;
		this.depertmentName = depertmentName;
	}

	public Department() {
		super();
		
	}
	
	
}
