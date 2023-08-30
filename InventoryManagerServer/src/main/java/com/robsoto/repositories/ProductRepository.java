package com.robsoto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
