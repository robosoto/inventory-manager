package com.robsoto.services;

import java.util.List;

import com.robsoto.models.Warehouse;


public interface WarehouseService {

	Warehouse findById(int id);
	
	List<Warehouse> findAll();

}
