package com.kartikeya.product.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kartikeya.product.entity.Product;
import com.kartikeya.product.exception.NoProperDataException;
import com.kartikeya.product.exception.ProductNotFoundException;
import com.kartikeya.product.repository.ProductRepository;
import com.kartikeya.product.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@InjectMocks
	private ProductServiceImpl service;
	
	@Mock
	private ProductRepository repository;
	
	@Test
	@DisplayName("Should save the product")
	void save() throws NoProperDataException {
		Product product1 = new Product();
		product1.setProductType("Electonics");
		product1.setProductName("Apple iphone 11");
		product1.setCategory("Mobile");
		product1.setRating("10");
		product1.setReview("Good Phone");
		product1.setImageUrl("Some Dummy URL");
		product1.setPrice("50000");
		product1.setSpecification("128 GB");
		product1.setDescription("A very good phone");
		
		when(repository.save(any(Product.class))).thenReturn(product1);
		
		Product newProduct = service.addProduct(product1);
		
		assertNotNull(newProduct);
		assertThat(newProduct.getProductName()).isEqualTo("Apple iphone 11");
	}
	
	@Test
	@DisplayName("Should return list of movies")
	void getProducts() {
		
		Product product1 = new Product();
		product1.setCust_id(1);
		product1.setProductType("Electonics");
		product1.setProductName("Apple iphone 11");
		product1.setCategory("Mobile");
		product1.setRating("10");
		product1.setReview("Good Phone");
		product1.setImageUrl("Some Dummy URL");
		product1.setPrice("50000");
		product1.setSpecification("128 GB");
		product1.setDescription("A very good phone");
		
		Product product2 = new Product();
		product2.setCust_id(2);
		product2.setProductType("Electonics");
		product2.setProductName("Apple iphone 12");
		product2.setCategory("Mobile");
		product2.setRating("10");
		product2.setReview("Good Phone");
		product2.setImageUrl("Some Dummy URL");
		product2.setPrice("50000");
		product2.setSpecification("128 GB");
		product2.setDescription("A very good phone");
		
		List<Product> list = new ArrayList<>();
		list.add(product1);
		list.add(product2);
		
		when(repository.findAll()).thenReturn(list);
		
		List<Product> products = service.getAllCustomers();
		assertEquals(2,products.size());
		assertNotNull(products);
	}
	
	@Test
	@DisplayName("Should return product with id ")
	void getProductById() throws ProductNotFoundException {
		Product product1 = new Product();
		product1.setCust_id(1);
		product1.setProductType("Electonics");
		product1.setProductName("Apple iphone 11");
		product1.setCategory("Mobile");
		product1.setRating("10");
		product1.setReview("Good Phone");
		product1.setImageUrl("Some Dummy URL");
		product1.setPrice("50000");
		product1.setSpecification("128 GB");
		product1.setDescription("A very good phone");
		
		when(repository.findById(anyInt())).thenReturn(Optional.of(product1));
		
		Product existingProduct=service.getProductById(1);
		assertNotNull(existingProduct);
		assertThat(existingProduct.getCust_id()).isEqualTo(1);
		
		
	}
	@Test
	@DisplayName("Should throw the Exception")
	void getProductByIdForException() {
		Product product1 = new Product();
		product1.setCust_id(1);
		product1.setProductType("Electonics");
		product1.setProductName("Apple iphone 11");
		product1.setCategory("Mobile");
		product1.setRating("10");
		product1.setReview("Good Phone");
		product1.setImageUrl("Some Dummy URL");
		product1.setPrice("50000");
		product1.setSpecification("128 GB");
		product1.setDescription("A very good phone");
		
		when(repository.findById(1)).thenReturn(Optional.of(product1));
		
		assertThrows(RuntimeException.class,()->{
			service.getProductById(2);
		});
	}
	
	@Test
	@DisplayName("Should delete the product")
	void deleteProduct() throws ProductNotFoundException {
		Product product1 = new Product();
		product1.setCust_id(1);
		product1.setProductType("Electonics");
		product1.setProductName("Apple iphone 11");
		product1.setCategory("Mobile");
		product1.setRating("10");
		product1.setReview("Good Phone");
		product1.setImageUrl("Some Dummy URL");
		product1.setPrice("50000");
		product1.setSpecification("128 GB");
		product1.setDescription("A very good phone");
		
		
		when(repository.findById(anyInt())).thenReturn(Optional.of(product1));
		   doNothing().when(repository).delete(any(Product.class));
		    
		   service.deleteProduct(1);
		   verify(repository, times(1)).delete(product1);

	}
}
