package com.robsoto.services;

import java.util.List;

import com.robsoto.dtos.ProductDto;
import com.robsoto.models.Product;

public interface ProductService {
	
	Product findById(int id);

	List<Product> findAllByWarehouseId(int id);
	
	List<Product> findAll();
	
	Product create(ProductDto productDto) throws Exception;
	
	Product update(ProductDto productDto);

	void delete(int id);

}
