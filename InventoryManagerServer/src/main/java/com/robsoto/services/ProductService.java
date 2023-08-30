package com.robsoto.services;

import java.util.List;

import com.robsoto.models.Product;

public interface ProductService {
	
	Product findById(int id);
	
	List<Product> findAll();
	
	Product create(Product product);
	
	Product update(Product product);
	
	void delete(int id);

}
