package com.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Dto.DepartmentDto;
//import com.NSE.NSEUploadAndDownload.Entity.Document;
import com.entity.Department;
import com.entity.Document;
import com.service.DocumentService;
import com.service.Impl.DepartmentImpl;

@Controller
public class DepartmentController {

	
	@Autowired
	private DocumentService documntservice;
	
	
	@Autowired
	private DepartmentImpl departmentImpl;
	
	@RequestMapping(value="/addDepartment",method = RequestMethod.GET)
	public String addDepartment(){
		return "adddepartment";
	}
	
	// added by faheem 
	@RequestMapping(value="/upload",method = RequestMethod.GET)
	public String upload(){
		return "upload";
	}
	
	
	// added by faheem
	
	@RequestMapping(value="/uploaddocument",method = RequestMethod.POST)
	public String uploaded(@RequestParam("file") CommonsMultipartFile file) {
		 System.out.println("hi faheem here");
		Document dto= new Document();
		dto.setBrowseFile(file);
		 String saveFile = documntservice.saveFile(dto);
		 
		 MultipartFile browseFile = dto.getBrowseFile();
		 System.out.println("browse file is " +browseFile);
		
		//DepartmentDto addDepartment = this.departmentImpl.addDepartment(departmentDto);
		
		
		
		return "adddepartment";
	}
	
	
	
	
	@RequestMapping(value="/saveDepartment",method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute @RequestBody DepartmentDto departmentDto) {
		
		DepartmentDto addDepartment = this.departmentImpl.addDepartment(departmentDto);
		return "adddepartment";
	}
	
	
	@RequestMapping(value="/getAllDepartment",method = RequestMethod.GET)
	public String getAllDepartment(Model model) {
		
		List<Department> allDepartment = this.departmentImpl.getAllDepartment();
		model.addAttribute("allDepartment", allDepartment);
		return "allDepartment";
	}
}
