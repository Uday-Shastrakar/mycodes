package com.spring.demo.dto;

public class ProductDto {

	private Long id;

	private String name;

	private String brandName;

	private Integer price;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
