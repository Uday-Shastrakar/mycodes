package com.project.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.EmployeeDto;
import com.project.model.DataE;
import com.project.service.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	@Autowired
	private ModelMapper modelMapper;

	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

//to get all employees
	@GetMapping("/emp")
	private List<EmployeeDto> getAllEmployes() {
		return employeeService.getAllEmployee().stream().map(DataE -> modelMapper.map(DataE, EmployeeDto.class))
				.collect(Collectors.toList());

	}

//to get employee by id
	@GetMapping("/emp/{id}")
	private ResponseEntity<EmployeeDto> getEmploye(@PathVariable Long id) {
		DataE data = employeeService.getEmployeeById(id);

		EmployeeDto response = modelMapper.map(data, EmployeeDto.class);

		return ResponseEntity.ok().body(response);

	}

//to delete Employee
	@DeleteMapping("/emp/{id}")
	private void deleteEmploye(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
	}

//to Save Employee data
@PostMapping("/emp")
private ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
	     
	DataE request = modelMapper.map(employeeDto, DataE.class);
	      
	DataE data = employeeService.createEmployee(request); 
	       
	       EmployeeDto response =modelMapper.map(data, EmployeeDto.class);
	       
	       return new ResponseEntity<EmployeeDto>(response,HttpStatus.OK);
          
	
}

//to update Employee data 
	@PutMapping("/emp/{id}")
	private ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @PathVariable EmployeeDto employeeDto) {
		DataE request = modelMapper.map(employeeDto, DataE.class);

		DataE data = employeeService.updateEmployee(id, request);

		EmployeeDto reponse = modelMapper.map(data, EmployeeDto.class);

		return ResponseEntity.ok().body(reponse);

	}
	
   /// pagination  request
	@PostMapping("/page")
  private ResponseEntity<List<EmployeeDto>>getPageEmployee(
		  @RequestParam(value = "pageNumber",defaultValue="10", required =false)Integer pageNuber,
		  @RequestParam(value= "pageSize",defaultValue = "1", required =false) Integer pageSize) {
	   List<EmployeeDto> allEmp = this.employeeService.getPageEmployee(pageNuber,pageSize);
	   
	    return new ResponseEntity<List<EmployeeDto>>(allEmp,HttpStatus.OK);
	  
  }
	
	
	
	
	

}
