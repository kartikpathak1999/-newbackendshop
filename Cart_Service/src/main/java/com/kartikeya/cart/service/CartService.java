package com.kartikeya.cart.service;

import java.util.List;

import com.kartikeya.cart.entity.Cart;
import com.kartikeya.cart.exception.CartNotFoundException;
import com.kartikeya.cart.exception.NoProperDataException;





public interface CartService {
	public List<Cart> getAllCustomers();
	public Cart getCartById(int id ) throws CartNotFoundException;
	public Cart addCart( Cart product) throws NoProperDataException;
	public String deleteCart(int id) throws CartNotFoundException;
	

}
