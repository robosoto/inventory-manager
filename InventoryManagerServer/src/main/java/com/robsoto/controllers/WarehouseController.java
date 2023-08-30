package com.robsoto.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robsoto.models.Warehouse;
import com.robsoto.services.WarehouseService;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

	private WarehouseService service;

	public WarehouseController(WarehouseService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Warehouse>> findAll() {
		List<Warehouse> warehouses = service.findAll();
		if (warehouses == null || warehouses.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(warehouses, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Warehouse> findById(@PathVariable int id) {
		Warehouse warehouse = service.findById(id);
		if (warehouse == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(warehouse, HttpStatus.OK);
	}

}
