package com.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dto.EmployeeDto;
import com.entity.Department;
import com.service.Impl.DepartmentImpl;

@Controller
public class HomeCtrl {

	
	@Autowired
	private DepartmentImpl departmentImpl;

	@RequestMapping("/home")
	public String home(Model model) {
		
		List<Department> allDepartment = this.departmentImpl.getAllDepartment();
		model.addAttribute("allDepartment", allDepartment);
		return "home";
	}
}
