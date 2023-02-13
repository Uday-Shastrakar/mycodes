package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Employee;

public interface DemoDao {

	
	List<Employee> getData(Integer departmentId);

	Object delete(Integer[] ids);

	Employee getRecordById(Integer id);

	boolean insert(Employee model);

	boolean update(Employee model);

}
