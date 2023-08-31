package com.robsoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robsoto.models.Warehouse;
import com.robsoto.repositories.WarehouseRepository;

@Service
public class WarehouseServiceDevImpl implements WarehouseService {
	
	private WarehouseRepository repo;
	
	public WarehouseServiceDevImpl(WarehouseRepository warehouseRepo) {
		this.repo = warehouseRepo;
	}

	@Override
	public Warehouse findById(int id) {
		Optional<Warehouse> warehouse = repo.findById(id);
		return warehouse.isPresent() ? warehouse.get() : null;
	}
	 
	@Override
	public List<Warehouse> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<Warehouse> findAll() {
		return (List<Warehouse>) repo.findAll();
	}

}
