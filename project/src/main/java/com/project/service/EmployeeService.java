package com.project.service;

import java.util.List;

import com.project.model.Employe;

public interface EmployeeService {
	
	 List<Employe> getAllEmployee();
	
	 Employe getEmployeById(Long id);
	
	 Employe saveEmploye(Employe employe);
	
	 void delete(Long id);
	
	 void update(Employe employe,Long id);

}
