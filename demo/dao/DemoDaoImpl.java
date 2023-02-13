package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

@Repository
public class DemoDaoImpl implements DemoDao {
	
	static Logger log=Logger.getLogger(DemoDaoImpl.class.getName());

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public Employee getRecordById(Integer id) {
		Employee response = new Employee();
		response = sessionfactory.getCurrentSession().get(Employee.class, id);
		return response;

	}

	@Override
	public boolean insert(Employee model) {

		sessionfactory.getCurrentSession().save(model);
		return true;
	}

	@Override
	public boolean update(Employee model) {
		sessionfactory.getCurrentSession().update(model);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getData(Integer departmentId) {
		

		
		List<Employee> models = new ArrayList<Employee>();
		try {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Employee.class);
		criteria.createAlias("department", "department");
		if(departmentId != null) {
		criteria.add(Restrictions.eq("department.deptId", departmentId));
		}
		models = criteria.list();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}

		return models;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object delete(Integer[] idList) {

		boolean response = false;
		try {
		for (int i = 0; i < idList.length; i++) {
			Employee employee = sessionfactory.getCurrentSession().get(Employee.class, idList[i]);
			sessionfactory.getCurrentSession().delete(employee);
			response = true;

		}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}

		
		return response;

	}

}