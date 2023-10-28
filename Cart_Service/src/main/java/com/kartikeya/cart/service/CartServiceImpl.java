package com.kartikeya.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartikeya.cart.entity.Cart;
import com.kartikeya.cart.exception.CartNotFoundException;
import com.kartikeya.cart.exception.NoProperDataException;
import com.kartikeya.cart.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public List<Cart> getAllCustomers()  {
		log.info("get all carts");
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(int id) throws CartNotFoundException {
		Cart cart=cartRepository.findById(id).orElseThrow(()-> new  CartNotFoundException("customer Not Found"+id));
		log.debug("customers getbyid {}",cart);
		return cart;
	}

	@Override
	public Cart addCart(Cart cart) throws NoProperDataException {
		if(cart!=null) 
		{
			cartRepository.save(cart);
			log.debug("customer added {}",cart);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return cart;
	}

	@Override
	public String deleteCart(int id) throws CartNotFoundException {
		log.info("Start delete");
		var isRemoved =cartRepository.findById(id);
		if(isRemoved.isPresent())
		{
			cartRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new CartNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return " deleted successfully";
	}
}
	
