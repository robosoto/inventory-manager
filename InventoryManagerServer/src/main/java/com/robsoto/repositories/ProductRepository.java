package com.robsoto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findAllByWarehouseId(int id);
	
}
