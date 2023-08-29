package com.robsoto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robsoto.models.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

}
