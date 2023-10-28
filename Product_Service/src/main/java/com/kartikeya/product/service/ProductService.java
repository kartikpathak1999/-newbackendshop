package com.kartikeya.product.service;

import java.util.List;

import com.kartikeya.product.entity.Product;
import com.kartikeya.product.exception.NoProperDataException;
import com.kartikeya.product.exception.ProductNotFoundException;



public interface ProductService {
	public List<Product> getAllCustomers();
	public Product getProductById(int id ) throws ProductNotFoundException;
	public Product addProduct( Product product) throws NoProperDataException;
	public String deleteProduct(int id) throws ProductNotFoundException;
	Product updateProduct(Product product, int id) throws ProductNotFoundException;

}
