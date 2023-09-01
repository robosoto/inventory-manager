package com.robsoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robsoto.dtos.ProductDto;
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
	
	public Product dtoToProduct(ProductDto productDto) {
		int warehouseId = productDto.getWarehouseId();
		Optional<Warehouse> warehouse = warehouseRepo.findById(warehouseId);
		
//		if (!warehouse.isPresent()) {
//			return null;
//		}
		
		return new Product(productDto.getName(), productDto.getDescription(), warehouse.get());
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
	public Product create(ProductDto productDto) throws Exception {
		Product product = dtoToProduct(productDto);
		Warehouse warehouse = product.getWarehouse();
		
		if (warehouse.getProducts().size() >= warehouse.getMaxCapacity()) {
			throw new Exception();
		}
		
		return productRepo.save(product);
	}
	
	@Override
	public Product update(ProductDto productDto) {
		Product product = dtoToProduct(productDto);
		
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
