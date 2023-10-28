package com.kartikeya.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartikeya.product.entity.Product;
import com.kartikeya.product.exception.NoProperDataException;
import com.kartikeya.product.exception.ProductNotFoundException;
import com.kartikeya.product.service.ProductServiceImpl;
import com.kartikeya.product.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v2")
@Slf4j 
public class ProductController {
	
	@Autowired 
	private ProductServiceImpl productserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allproducts")
	public ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException
	{
		
		List<Product> customers=productserviceimpl.getAllCustomers();  
		log.info("starting  of get mapping");
	
		if(customers.size()>0) {
			log.debug("customers are {}"
					+ customers);
		 return new  ResponseEntity<>(customers,HttpStatus.OK); 
		}
		else {
			log.debug(" no customers found ");
			 return new  ResponseEntity<>(customers,HttpStatus.NO_CONTENT); 
		}
	}
	

	@GetMapping("products/{id}")
	public ResponseEntity<Product> getOrderById(@PathVariable  int id) throws ProductNotFoundException {
		Product product= productserviceimpl.getProductById(id);
		if(product!=null){
		  return ResponseEntity.ok().body(product);
		}
		  else {
			return new   ResponseEntity<Product>(product,HttpStatus.NOT_FOUND);
		  }
	}
//	@GetMapping("/products/{id}")
//	public ResponseEntity<Product> getProductById( @PathVariable  int id)
//			throws ProductNotFoundException	
//				
//				{
//					log.info("starting  of get mapping");
//					Product customers=productserviceimpl.getProductById(id);
//				
//					if(customers.getCust_id()!=0) {
//						log.debug("customers are {}"
//								+ customers);
//					 return new  ResponseEntity<>(customers,HttpStatus.OK); 
//					}
//					else {
//						log.debug(" no customers found ");
//						 return new  ResponseEntity<>(customers,HttpStatus.NOT_FOUND); 
//					}
//				}
	@PostMapping("/addProducts") 
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product)  throws NoProperDataException
	{
		if(product!=null) 
		{
			
			product.setCust_id(service.getSequenceNumberForCustomer(Product.SEQUENCE_NAME));
			productserviceimpl.addProduct(product);
			log.error("added product");
			return new ResponseEntity<>(product,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields"); 
		}
		
		
	}

	@DeleteMapping(path="/products/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws ProductNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				productserviceimpl.deleteProduct(id);
			} catch (ProductNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			return ResponseEntity.ok(" deleted operation done ");
	
	}
	
	@PutMapping (path="/product/{id}")
	public ResponseEntity<Product> updateOrder(@RequestBody Product product, @PathVariable int id ) throws ProductNotFoundException{
		return new ResponseEntity<Product>(productserviceimpl.updateProduct (product,id),HttpStatus.OK);
	}


}
