package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.DataE;

public interface EmployeeService {
	
	 List<DataE> getAllEmployee();
	
	Optional<DataE> getEmployeById(Long id);
	
	 DataE saveEmploye(DataE employe);
	
	 void delete(Long id);
	
	 void update(DataE employe,Long id);

}
