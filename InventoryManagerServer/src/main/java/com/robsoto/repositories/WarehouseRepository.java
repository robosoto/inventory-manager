package com.robsoto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.models.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
	
	List<Warehouse> findByName(String name);

}
