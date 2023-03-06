package com.spring.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.model.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Products product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	@Override
	public boolean update(Products product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	@Override
	public Products getById(Long id) {
		// TODO Auto-generated method stub
		Products p = new Products();
		p = sessionFactory.getCurrentSession().get(Products.class, id);
		return p;
	}

	@Override
	public boolean deleteAllById(Long[] id) {
		boolean resp = false;

		for (int i = 0; i < id.length; i++) {
			Products pro = sessionFactory.getCurrentSession().get(Products.class, id[i]);
			sessionFactory.getCurrentSession().delete(pro);
			resp = true;
		}
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		List<Products>  products = new ArrayList<Products>(); 
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Products.class);
		products=criteria.list();
	    
		return products;
	}

}
