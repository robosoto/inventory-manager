import { Component } from '@angular/core';
import { WarehouseService } from '../services/warehouse.service';
import { Warehouse } from '../entities/warehouse';

@Component({
  selector: 'app-warehouses',
  templateUrl: './warehouses.component.html',
  styleUrls: ['./warehouses.component.css']
})
export class WarehousesComponent {

  warehouses: Warehouse[] = [];

  constructor(private warehouseService: WarehouseService) {}

  getWarehouses(): void {
    this.warehouseService.getWarehouses().subscribe(warehouses => this.warehouses = warehouses);
  }

  ngOnInit(): void {
    this.getWarehouses();
  }

}
