package com.project.service;

import java.util.List;

import com.project.dto.EmployeeDto;
import com.project.model.DataE;

public interface EmployeeService {
	
	 List<DataE> getAllEmployee();
	
	 List<EmployeeDto> getPageEmployee(Integer pagenumber, Integer pageSize);
	 
	 DataE createEmployee(DataE data );
	
	 void deleteEmployee(Long id);
	
	 DataE updateEmployee(Long id,DataE dataE);
	 
	 DataE getEmployeeById(Long id);

}
