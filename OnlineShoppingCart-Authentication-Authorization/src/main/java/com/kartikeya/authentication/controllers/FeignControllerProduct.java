package com.kartikeya.authentication.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartikeya.authentication.exception.NoProperDataException;
import com.kartikeya.authentication.exception.ProductNotFoundException;
import com.kartikeya.authentication.models.Product;
import com.kartikeya.authentication.service.SequenceGeneratorService;
import com.kartikeya.authentication.util.FiegnClientUtilProduct;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v2")
public class FeignControllerProduct {
	

	@Autowired
	private FiegnClientUtilProduct feignproduct;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allproducts") 
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<Product>> getAllProduct(@RequestHeader("Authorization") String token) throws ProductNotFoundException
	{
		
		return feignproduct.getAllProduct(token);
		
	}
	
	@GetMapping("/products/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Product> getProductById(@Valid @RequestHeader("Authorization") String token,@PathVariable  int id)
	throws ProductNotFoundException{
		return feignproduct.getProductById(token,id);
	}
	
	@PostMapping("/addProducts") 
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)  throws NoProperDataException
	{
		product.setCust_id(service.getSequenceNumberForProduct(Product.SEQUENCE_NAME));
		return feignproduct.addProduct(product);
	}


	@DeleteMapping("/products/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deleteProduct( @RequestHeader("Authorization") String token,@PathVariable int id) throws ProductNotFoundException {
			return feignproduct.deleteProduct(token,id);
	}

}
