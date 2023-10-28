package com.kartikeya.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class OnlineShoppingCartAuthenticationAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingCartAuthenticationAuthorizationApplication.class, args);
	}

	
}
