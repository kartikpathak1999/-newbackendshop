package com.kartikeya.authentication.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.kartikeya.authentication.models.Product;



@FeignClient(value="Customer-Service",url="http://localhost:8086/api/v2")
public interface FiegnClientUtilProduct {
	
	@GetMapping("/allproducts") 
	public ResponseEntity<List<Product>> getAllProduct(@RequestHeader("Authorization") String token);
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@RequestHeader("Authorization") String token, @PathVariable int id);
	
	
	@PostMapping("/addProducts") 
	public ResponseEntity<Product> addProduct(Product customer);

	
	
	@DeleteMapping(path="/products/{id}")
	public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization") String token,@PathVariable int id);


}
