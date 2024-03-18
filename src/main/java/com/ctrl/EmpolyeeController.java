package com.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dto.EmployeeDto;
import com.entity.Employee;
import com.service.Impl.DepartmentImpl;
import com.service.Impl.EmpolyeeImpl;


@Controller
public class EmpolyeeController {

	@Autowired
	private EmpolyeeImpl empolyeeImpl;
		
	@RequestMapping(value="/saveEmpolyee",method = RequestMethod.POST)
	public String createEmp(@ModelAttribute EmployeeDto emp) {
		EmployeeDto addEmployee = this.empolyeeImpl.addEmployee(emp);
		System.out.println(addEmployee);
		return "redirect:/getAllDepartment";
	}
	
	@RequestMapping(value="getEmoplyee/{empId}",method=RequestMethod.GET)
	public String getEmpolyee(@PathVariable int empId,Model model) {
		EmployeeDto empolyee = this.empolyeeImpl.getEmpolyee(empId);
		model.addAttribute("empolyee", empolyee);
		return "viewempolyee";
	}
	
	@RequestMapping(value="/getAllEmoplyee/{departmentId}",method=RequestMethod.GET)
	public String getAllEmpolyee(Model model,@PathVariable int departmentId) {
		List<Employee> allEmpolyee = this.empolyeeImpl.getAllEmpolyee(departmentId);
		model.addAttribute("allEmpolyee", allEmpolyee);
		return "allEmpolyee";
	}
}
