package com.spring.demo.service;



import java.util.List;

import com.spring.demo.dto.ProductDto;
import com.spring.demo.model.Products;

public interface ProductService {

	Object createProduct(ProductDto product);
	
	Object updateProduct(ProductDto product); 
	
	Object deleteProduct(Long[] id);
	
	List<Products> getAllProducts();
	

}
