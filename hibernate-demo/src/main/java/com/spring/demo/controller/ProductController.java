package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.demo.dto.ProductDto;
import com.spring.demo.model.Products;
import com.spring.demo.service.ProductService;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/propost")
	private Object createStudent(@RequestBody ProductDto product) {
		return productService.createProduct(product);

	}
	
	@PutMapping("/proput")
	private Object updateProduct(@RequestBody ProductDto  product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/prodel/{id}")
	private Object deleteProduct(@PathVariable Long[] id) {
      return  productService.deleteProduct(id);
	}
	
	@GetMapping("/get")
   private List<Products>  getAllProduct(){
	return productService.getAllProducts();
	   
   }

}
