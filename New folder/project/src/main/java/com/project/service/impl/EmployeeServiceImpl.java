package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.project.model.DataE;
import com.project.repository.EmployeRepository;
import com.project.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	EmployeRepository employeRepository;
	
	public EmployeeServiceImpl(EmployeRepository employeRepository) {
		super();
		this.employeRepository = employeRepository;
	}

	@Override
	public List<DataE> getAllEmployee() {
		// TODO Auto-generated method stub
		List<DataE> employes = new ArrayList<DataE>();
		employeRepository.findAll().forEach(employe -> employes.add(employe));
		return employes ;
	}

	@Override
	public Optional<DataE> getEmployeById(Long id) {
		// TODO Auto-generated method stub
		
		return employeRepository.findById(id);
	}

	@Override
	public DataE saveEmploye(DataE employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		employeRepository.deleteById(id);
	}

	@Override
	public void update(DataE employe, Long id) {
		// TODO Auto-generated method stub
		employeRepository.save(employe);
		
	}
	

}
