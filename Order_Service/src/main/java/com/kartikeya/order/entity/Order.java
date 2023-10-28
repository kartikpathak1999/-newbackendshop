package com.kartikeya.order.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	@Document(collection="order")
	public class Order {
		
		
		public static final String SEQUENCE_NAME = "order_sequence";
		@Id
	    private int bookingOrderId;
		
		private String orderDate;
	   
	    
	    public String address;
	    @Size(max = 40)
		
		double totalCost;
		@NotBlank(message="enter valid totalCost")
		@Size(max = 40)
	    
		
		private String orderName;
		
		private List<String> items = new  ArrayList<>();

		
	  
}