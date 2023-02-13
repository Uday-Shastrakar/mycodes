package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DemoDao;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Department;
import com.example.demo.models.Employee;

@Service
@Transactional
public class DemoServiceImpl implements DemoService{

	static Logger log = Logger.getLogger(DemoServiceImpl.class.getName());

	@Autowired
	private DemoDao dao;

	@Override
	public Object insert(EmployeeDto dto) {
		boolean success=false;
		try {
		Employee model = new Employee();
		model.setName(dto.getName());
		model.setDesignation(dto.getDesignation());
		if (dto.getDepartmentId() != null) {
			model.setDepartment(new Department(dto.getDepartmentId()));
		}
		 success = dao.insert(model);

		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		return success;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object delete(Integer[] idList) {
		Object response = dao.delete(idList);
		return response;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeDto> get(Integer departmentId) {
		
		

		List<EmployeeDto> dtos = new ArrayList<>();
		try {

		List<Employee> models = dao.getData(departmentId);

		for (Employee master : models) {
			EmployeeDto dto = new EmployeeDto();
			dto.setEmpId(master.getEmpId());
			dto.setName(master.getName());
			dto.setDesignation(master.getDesignation());
			if (master.getDepartment() != null) {
				dto.setDepartmentId(master.getDepartment().getDeptId());
				dto.setDepartmentName(master.getDepartment().getName());
			}
			dtos.add(dto);
		}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}

		return dtos;
	}

	@Override
	public Object update(EmployeeDto dto) {
		boolean success = false;
		try {
		Employee model = dao.getRecordById(dto.getEmpId());
		model.setName(dto.getName());
		model.setDesignation(dto.getDesignation());
		if (dto.getDepartmentId() != null) {
			model.setDepartment(new Department(dto.getDepartmentId()));
		}
		 success = dao.update(model);

		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		return success;

	}

	
}
