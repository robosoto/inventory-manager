package com.robsoto.InventoryManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.InventoryManager.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	
	
}
