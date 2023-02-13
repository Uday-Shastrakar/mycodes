package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired
	DemoService service;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<EmployeeDto> getdata(Integer departmentId) {
		return service.get(departmentId);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Object insertdata(EmployeeDto dto) {
		return service.insert(dto);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Object deletedata(Integer[] idList) {
		return service.delete(idList);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object updatedata(EmployeeDto dto) {
		return service.update(dto);
	}
	
	
}