package com.kartikeya.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kartikeya.product.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
