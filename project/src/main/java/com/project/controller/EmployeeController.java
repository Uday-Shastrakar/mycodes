package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.model.Employe;
import com.project.service.EmployeeService;
@RestController
@RequestMapping("/api")
public class EmployeeController {
EmployeeService employeeService;


public EmployeeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}

//to get all employees
@GetMapping("/emp")
private List<Employe> getAllEmployes(){
	return employeeService.getAllEmployee();
	
}

//to get employee by id
@GetMapping("/emp/{id}")
private Employe getEmploye(@PathVariable("id")Long id) {
	return employeeService.getEmployeById(id);
	
}

//to delete Employee
@DeleteMapping("/emp/{id}")
private void deleteEmploye(@PathVariable("id")Long id) {
	employeeService.delete(id);
}

//to Save Employee data
@PostMapping("/emp")
private ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe) {
	Employe savedEmp = employeeService.saveEmploye(employe);
	return new ResponseEntity<>(savedEmp, HttpStatus.OK);
	
}

//to update Employee data 
@PutMapping("/emp")
private Employe updateEmploye(@RequestBody Employe employe) {
	employeeService.saveEmploye(employe);;
	return employe;
	
}










}
