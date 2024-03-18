package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	Department findByDepertmentName(String departmentName);
}
