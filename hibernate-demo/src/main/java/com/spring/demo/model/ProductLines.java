package com.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name ="productlines")
public class ProductLines {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String description;
	
	
	
	

}
