package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface DemoService {

	List<EmployeeDto> get(Integer departmentId);
	
	

	Object insert(EmployeeDto dto);

	Object delete(Integer[] idList);

	Object update(EmployeeDto dto);
}
