package com.kartikeya.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartikeya.product.entity.Product;
import com.kartikeya.product.exception.NoProperDataException;
import com.kartikeya.product.exception.ProductNotFoundException;
import com.kartikeya.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllCustomers() {
		log.info("get all products");
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
		Product product=productRepository.findById(id).orElseThrow(()-> new  ProductNotFoundException("customer Not Found"+id));
		log.debug("customers getbyid {}",product);
		return product;
	}

	@Override
	public Product addProduct(Product product) throws NoProperDataException {
		if(product!=null) 
		{
			productRepository.save(product);
			log.debug("customer added {}",product);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return product;
	}
	@Override
	public String deleteProduct(int id) throws ProductNotFoundException {
		log.info("Start delete");
		var isRemoved =productRepository.findById(id);
		if(isRemoved.isPresent())
		{
			productRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new ProductNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return " deleted successfully";
	}
	
	 @Override
	    public Product updateProduct(Product product, int id) throws ProductNotFoundException {
	        Product existingproduct= productRepository.findById(id).orElseThrow(
	                ()->new ProductNotFoundException("To Update coupon is not present in the databse"));
	                existingproduct.setProductType(product.getProductType());
	                existingproduct.setProductName(product.getProductName());
	                existingproduct.setCategory(product.getCategory());
	                existingproduct.setRating(product.getRating());
	                existingproduct.setReview(product.getReview());
	                existingproduct.setImageUrl(product.getImageUrl());
	                existingproduct.setPrice(product.getPrice());
	                existingproduct.setDescription(product.getDescription());
	                existingproduct.setSpecification(product.getSpecification());
	                 

	                productRepository.save(existingproduct);
	                return existingproduct ;


	    }
//	@Override
//	public String deleteProduct(Integer id) throws ProductNotFoundException {
//		log.info("Start delete");
//		var isRemoved =productRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			productRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new ProductNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return " deleted successfully";
//	}

}
