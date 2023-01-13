package com.project.service;

import java.util.List;

import com.project.model.Employe;

public interface EmployeeService {
	
	public List<Employe> getAllEmployee();
	
	public Employe getEmployeById(Long id);
	
	public Employe saveEmploye(Employe employe);
	
	public void delete(Long id);
	
	public void update(Employe employe,Long id);

}
