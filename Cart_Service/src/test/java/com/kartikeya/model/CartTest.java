package com.kartikeya.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kartikeya.cart.entity.Cart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class CartTest {

	 Cart c1 = new Cart();
	   
	 @BeforeEach
	    public void before() {
	     Cart c2 = new Cart(1,"grocery","6","89.00");
	    }
        @AfterEach
	    public void after() {
	        c1=null;
	    }
	    
//	    @Test
//	    void testGetCust_id() {
//	    	assertEquals(1,p1.getCust_id());
//	    }
//	    
//	    @Test
//	    void testGetCartType() {
//	    	assertEquals("Electronics",p1.getCartType());
//	    }
//	    
//	    @Test
//	    void testGetCartName() {
//	    	assertEquals("Apple Iphone",p1.getCartName());
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
//	    void testSetCartType() {
//	    	p1.setCartType("Electronics");
//	    	assertEquals("Electronics",p1.getCartType());
//	    }
//	    
//	    @Test
//	    void testSetCartName() {
//	    	p1.setCartName("Apple Iphone");
//	    	assertEquals("Apple Iphone",p1.getCartName());
//	    }
//	    
        @Test
    void testGetCust_id() {
        	c1.setCust_id(1);
	    	assertEquals(1,c1.getCust_id());
	   
        }	    
        
        
	    @Test
	    void testSetCartname() {
	    	c1.setCartname("grocery");
	    	assertEquals("grocery",c1.getCartname());
	    }
	    
	    @Test
	    void testSetNo_of_carts() {
	    	c1.setNo_of_carts("6");
	    	assertEquals("6",c1.getNo_of_carts());
	    }
	    
	    @Test
	    void testSetPrices() {
	    	c1.setPrices("89.00");
	    	assertEquals("89.00",c1.getPrices());
	    }
}
	 