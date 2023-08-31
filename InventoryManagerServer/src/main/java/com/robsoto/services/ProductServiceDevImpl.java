package com.robsoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robsoto.models.Product;
import com.robsoto.models.Warehouse;
import com.robsoto.repositories.ProductRepository;
import com.robsoto.repositories.WarehouseRepository;

@Service
public class ProductServiceDevImpl implements ProductService {
	
	private ProductRepository productRepo;
	private WarehouseRepository warehouseRepo;
	
	public ProductServiceDevImpl(ProductRepository productRepo, WarehouseRepository warehouseRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public Product findById(int id) {
		Optional<Product> product = productRepo.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product create(Product product) throws Exception {
		int warehouseId = product.getWarehouse().getId();
		Optional<Warehouse> warehouse = warehouseRepo.findById(warehouseId);
		
		if (!warehouse.isPresent()) {
			throw new Exception(); // TODO: create custom exception? look up ExceptionHandler for the controller
		}
		
		if (warehouse.get().getProducts().size() >= warehouse.get().getMaxCapacity()) {
			throw new Exception(); // TODO: custom exception? or just return null?
		}
		
		return productRepo.save(product);
	}
	
	@Override
	public Product update(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void delete(int id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findAllByWarehouseId(int id) {
		return productRepo.findAllByWarehouseId(id);
	}

}
