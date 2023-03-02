package com.project.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.dto.EmployeeDto;
import com.project.exception.ResourceNotFoundException;
import com.project.model.DataE;
import com.project.repository.EmployeRepository;
import com.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;
	EmployeRepository employeRepository;

	public EmployeeServiceImpl(EmployeRepository employeRepository) {
		super();
		this.employeRepository = employeRepository;
	}

	@Override
	public List<DataE> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}
	
	@Override
	public DataE createEmployee(DataE data) {
		// TODO Auto-generated method stub
		
		return employeRepository.save(data);
		
	}


	

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		DataE data = employeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DataE", "id", id));
          employeRepository.delete(data);
	}

	@Override
	public DataE updateEmployee(Long id, DataE dataRequest) {
     
		DataE data = employeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("DataE", "id", id));
		       data.setFirstName(dataRequest.getFirstName());
		       data.setLastName(dataRequest.getLastName());
		       data.setEmail(dataRequest.getEmail());
		return employeRepository.save(data);
		// TODO Auto-generated method stub

	}

	@Override
	public DataE getEmployeeById(Long id) {
		Optional<DataE> result = employeRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else
			throw new ResourceNotFoundException("DataE", "id", id);
	}

	@Override
	public List<EmployeeDto> getPageEmployee(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		
		PageRequest p = PageRequest.of(pageNumber, pageSize);
		
	 	Page<DataE> pageData = this.employeRepository.findAll(p);
	 	List<DataE> allEmp = pageData.getContent(); 
	 	
	 	List<EmployeeDto> employeeDto = allEmp.stream().map(DataE -> modelMapper.map(DataE, EmployeeDto.class))
				.collect(Collectors.toList());
	 	
	 	
	 	return employeeDto;
	}

	
}
