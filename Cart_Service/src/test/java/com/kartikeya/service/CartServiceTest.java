package com.kartikeya.service;


	
	
	
	

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

import com.kartikeya.cart.entity.Cart;
import com.kartikeya.cart.exception.CartNotFoundException;
import com.kartikeya.cart.exception.NoProperDataException;
import com.kartikeya.cart.repository.CartRepository;
import com.kartikeya.cart.service.CartServiceImpl;





@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	
	@InjectMocks
	private CartServiceImpl service;
	
	@Mock
	private CartRepository repository;
	
	@Test
	@DisplayName("Should save the Cart")
	void save() throws NoProperDataException {
		Cart cart1 = new Cart();
		cart1.setCust_id(1);
		cart1.setCartname("grocery");
		cart1.setNo_of_carts("6");
		cart1.setPrices("78");
		
		
		when(repository.save(any(Cart.class))).thenReturn(cart1);
		
		Cart newCart = service.addCart(cart1);
		
		assertNotNull(newCart);
		assertThat(newCart.getCartname()).isEqualTo("grocery");
	}
	
	@Test
	@DisplayName("Should return list of movies")
	void getCart() {
		
		Cart cart1 = new Cart();
		cart1.setCust_id(1);
		cart1.setCartname("grocery");
		cart1.setNo_of_carts("6");
		cart1.setPrices("78");
		
		Cart cart2 = new Cart();
		cart2.setCust_id(2);
		cart2.setCartname("grocery2");
		cart2.setNo_of_carts("6");
		cart2.setPrices("78");
		
		
		
		List<Cart> list = new ArrayList<>();
		list.add(cart1);
		list.add(cart2);
		
		when(repository.findAll()).thenReturn(list);
		
		List<Cart> carts = service.getAllCustomers();
		assertEquals(2,carts.size());
		assertNotNull(carts);
	}
	
	@Test
	@DisplayName("Should return Cart with id ")
	void getCartById() throws CartNotFoundException {
		Cart cart1 = new Cart();
		cart1.setCust_id(1);
		cart1.setCartname("grocery");
		cart1.setNo_of_carts("6");
		cart1.setPrices("78");
		
		
		when(repository.findById(anyInt())).thenReturn(Optional.of(cart1));
		
		Cart existingCart=service.getCartById(1);
		assertNotNull(existingCart);
		assertThat(existingCart.getCust_id()).isEqualTo(1);
	}
		
	
	@Test
	@DisplayName("Should throw the Exception")
	void getCartByIdForException() {
		
		
		
		Cart cart1 = new Cart();
		cart1.setCust_id(1);
		cart1.setCartname("grocery");
		cart1.setNo_of_carts("6");
		cart1.setPrices("78");
		
		
	
		
		
		when(repository.findById(1)).thenReturn(Optional.of(cart1));
		
		assertThrows(RuntimeException.class,()->{
			service.getCartById(2);
		});
		
	
	}
	
	
	@Test
	@DisplayName("Should delete the Cart")
	void deleteCart() throws CartNotFoundException {
		Cart Cart1 = new Cart();
	
		

		Cart cart1 = new Cart();
		cart1.setCust_id(1);
		cart1.setCartname("grocery");
		cart1.setNo_of_carts("6");
		cart1.setPrices("78");
		
		
		
		when(repository.findById(anyInt())).thenReturn(Optional.of(Cart1));
		   doNothing().when(repository).delete(any(Cart.class));
		    
		   service.deleteCart(1);
		   verify(repository, times(1)).delete(Cart1);

	}
}
	
	
	
	
	
	
	
	
	
	
	


