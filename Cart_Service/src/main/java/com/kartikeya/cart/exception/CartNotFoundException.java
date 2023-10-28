package com.kartikeya.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends Exception{
	public CartNotFoundException(String message) {
		super(message);
	}
}
