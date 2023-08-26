package com.robsoto.InventoryManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.InventoryManager.models.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

}
