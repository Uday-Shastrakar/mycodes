package com.spring.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.dto.ProductDto;
import com.spring.demo.model.Products;
import com.spring.demo.repository.ProductRepository;
import com.spring.demo.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Object createProduct(ProductDto product) {
		boolean sucess = false;
		Products pro = new Products();
		pro.setName(product.getName());
		pro.setBrandName(product.getBrandName());
		pro.setName(product.getPrice());
		sucess = productRepository.save(pro);
		return sucess;
	}

	@Override
	public Object updateProduct(ProductDto product) {
		boolean sucess = false;
		Products pro = productRepository.getById(product.getId());
		pro.setName(product.getName());
		pro.setBrandName(product.getBrandName());
		pro.setPrice(product.getPrice());
		sucess = productRepository.save(pro);
		return sucess;
	}

	@Override
	public Object deleteProduct(Long[] id) {
	     
     Object sucess = productRepository.deleteAllById(id);
		return sucess;
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
	List<Products> products = productRepository.getAllProducts();
	return products;
	
	}

}
