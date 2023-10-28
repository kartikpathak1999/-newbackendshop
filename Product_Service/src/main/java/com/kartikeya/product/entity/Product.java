package com.kartikeya.product.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product_details")
public class Product {
   
	public static final String SEQUENCE_NAME = "customer_sequence";
	@Id
	private int cust_id;
	
	
	@NotBlank(message="product type  is required")
	@Size(max = 40)
	private String productType;
	
	@NotBlank(message="product name  is required")
	@Size(max = 40)
	private String productName;
	
	@NotBlank(message="product category  is required")
	@Size(max = 40)
	private String category;
	
	@NotBlank(message="product rating  is required")
	@Size(max = 40)
	private String rating;
	
	@NotBlank(message="product review  is required")
	@Size(max = 40)
	private String review;
	
	@NotBlank(message="product image  is required")
	@Size(max = 40)
	private String imageUrl ;
	
	@NotBlank(message="product price  is required")
	@Size(max = 40)
	private String price;
	
	@NotBlank(message="product description  is required")
	@Size(max = 40)
	private String description;
	
	@NotBlank(message="product specification  is required")
	@Size(max = 40)
	private String specification;
	
	
	
	
}
