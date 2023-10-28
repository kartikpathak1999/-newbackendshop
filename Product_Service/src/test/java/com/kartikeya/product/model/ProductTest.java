package com.kartikeya.product.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kartikeya.product.entity.Product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class ProductTest {

	 Product p1 = new Product();
	   
	 @BeforeEach
	    public void before() {
	     Product p2 = new Product(1,"Electronics","Apple Iphone","Mobile","10","Good Phone", "Some Dummy URL", "50000", "128GB","A very good phone");
	    }
        @AfterEach
	    public void after() {
	        p1=null;
	    }
	    
//	    @Test
//	    void testGetCust_id() {
//	    	assertEquals(1,p1.getCust_id());
//	    }
//	    
//	    @Test
//	    void testGetProductType() {
//	    	assertEquals("Electronics",p1.getProductType());
//	    }
//	    
//	    @Test
//	    void testGetProductName() {
//	    	assertEquals("Apple Iphone",p1.getProductName());
//	    }
//	    
//	    @Test
//	    void testGetCategory() {
//	    	assertEquals("Mobile",p1.getCategory());
//	    }
//	    
//	    @Test
//	    void testGetRating() {
//	    	assertEquals("10",p1.getRating());
//	    }
//	    
//	    @Test
//	    void testGetReview() {
//	    	assertEquals("Good Phone",p1.getReview());
//	    }
//	    
//	    @Test
//	    void testGetImageUrl() {
//	    	assertEquals("Some Dummy URL",p1.getImageUrl());
//	    }
//	    
//	    @Test
//	    void testGetPrice() {
//	    	assertEquals("50000",p1.getPrice());
//	    }
//	    
//	    @Test
//	    void testGetDescription() {
//	    	assertEquals("128GB",p1.getDescription());
//	    }
//	    
//	    @Test
//	    void testGetSpecification() {
//	    	assertEquals("A very good phone",p1.getSpecification());
//	    }
//	    
//	    @Test
//	    void testSetCust_id() {
//	    	p1.setCust_id(1);
//	    	assertEquals(1,p1.getCust_id());
//	    }
//	    
//	    @Test
//	    void testSetProductType() {
//	    	p1.setProductType("Electronics");
//	    	assertEquals("Electronics",p1.getProductType());
//	    }
//	    
//	    @Test
//	    void testSetProductName() {
//	    	p1.setProductName("Apple Iphone");
//	    	assertEquals("Apple Iphone",p1.getProductName());
//	    }
//	    
	    @Test
	    void testSetCategory() {
	    	p1.setCategory("Mobile");
	    	assertEquals("Mobile",p1.getCategory());
	    }
	    
	    @Test
	    void testSetRating() {
	    	p1.setRating("10");
	    	assertEquals("10",p1.getRating());
	    }
	    
	    @Test
	    void testSetReview() {
	    	p1.setReview("Good Phone");
	    	assertEquals("Good Phone",p1.getReview());
	    }
	    
	    @Test
	    void testSetImageUrl() {
	    	p1.setImageUrl("Some Dummy URL");
	    	assertEquals("Some Dummy URL",p1.getImageUrl());
	    }
	    
	    @Test
	    void testSetPrice() {
	    	p1.setPrice("50000");
	    	assertEquals("50000",p1.getPrice());
	    }
	    
	    @Test
	    void testSetDescription() {
	    	p1.setDescription("128GB");
	    	assertEquals("128GB",p1.getDescription());
	    }
	    
	    @Test
	    void testSetSpecification() {
	    	p1.setSpecification("A very good phone");
	    	assertEquals("A very good phone",p1.getSpecification());
	    }
	    
	    
}
