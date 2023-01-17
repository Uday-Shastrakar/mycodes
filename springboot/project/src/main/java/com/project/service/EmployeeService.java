package com.project.service;

import java.util.List;


import com.project.model.DataE;

public interface EmployeeService {

	 List<DataE> getAllEmployee();
	
	 List<DataE> getPageEmployee(Integer pagenumber,Integer pageSize,String sortBy);
	 
	 DataE createEmployee(String fistName, String lastName, String email );
	
	 void deleteEmployee(Long id);
	
	 DataE updateEmployee(Long id,DataE dataE);
	 
	 DataE getEmployeeById(Long id);

}
