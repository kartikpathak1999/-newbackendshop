package com.kartikeya.cart.entity;

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
public class Cart {
   
	public static final String SEQUENCE_NAME = "customer_sequence";
	@Id
	private int cust_id;
	
	
	@NotBlank(message="cartname is required")
	@Size(max = 40)
	private String cartname;
	

	
	@NotBlank(message="no of carts")
	
	private String no_of_carts;
	
	@NotBlank(message="prices of carts")
	private String prices;
}

