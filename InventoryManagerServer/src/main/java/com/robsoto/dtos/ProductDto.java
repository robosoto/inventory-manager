package com.robsoto.dtos;

public class ProductDto {

	private String name;
	private String description;
	private int warehouseId;
	
	public ProductDto() {}

	public ProductDto(String name, String description, int warehouseId) {
		super();
		this.name = name;
		this.description = description;
		this.warehouseId = warehouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

}
