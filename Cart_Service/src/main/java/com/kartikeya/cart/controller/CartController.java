package com.kartikeya.cart.controller;

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

import com.kartikeya.cart.entity.Cart;
import com.kartikeya.cart.exception.CartNotFoundException;
import com.kartikeya.cart.exception.NoProperDataException;
import com.kartikeya.cart.service.CartServiceImpl;
import com.kartikeya.cart.service.SequenceGeneratorService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@Slf4j
@RequestMapping("api/v2")

public class CartController {
	
	@Autowired 
	private CartServiceImpl cartserviceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allcarts")
	public ResponseEntity<List<Cart>> getAllCart() throws CartNotFoundException
	{
		
		List<Cart> customers=cartserviceimpl.getAllCustomers();
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
	



	@GetMapping("/carts/{id}")
	public ResponseEntity<Cart> getCartId(@Valid @PathVariable  int id)
			throws CartNotFoundException	
				
				{
					log.info("starting  of get mapping");
					Cart customers=cartserviceimpl.getCartById(id);
				
					if(customers.getCust_id()!=0) {
						log.debug("customers are {}"
								+ customers);
					 return new  ResponseEntity<>(customers,HttpStatus.OK); 
					}
					else {
						log.debug(" no customers found ");
						 return new  ResponseEntity<>(customers,HttpStatus.NOT_FOUND); 
					}
				}
	@PostMapping("/addCart") 
	public ResponseEntity<Cart> addCart(@Valid @RequestBody Cart cart)  throws NoProperDataException
	{
		if(cart!=null) 
		{
			
		    cart.setCust_id(service.getSequenceNumberForCustomer(Cart.SEQUENCE_NAME));
			cartserviceimpl.addCart(cart);
			log.error("added product");
			return new ResponseEntity<>(cart,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		
		
	}

	

	@DeleteMapping(path="/cart/{id}")
	public ResponseEntity<String> deleteCart(@Valid @PathVariable int id) throws CartNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				cartserviceimpl.deleteCart(id);
			} catch (CartNotFoundException e) {
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
}