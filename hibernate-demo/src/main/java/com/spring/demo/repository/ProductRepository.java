package com.spring.demo.repository;



import java.util.List;

import com.spring.demo.model.Products;

public interface ProductRepository {

	boolean save(Products product);

	boolean update(Products product);

	Products getById(Long id);

	boolean deleteAllById(Long[] id);
	
	List<Products> getAllProducts();

}
