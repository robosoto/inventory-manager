import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../services/product.service';
import { WarehouseService } from '../services/warehouse.service';
import { Location } from '@angular/common';
import { Product } from '../entities/product';
import { Warehouse } from '../entities/warehouse';

@Component({
  selector: 'app-warehouse-detail',
  templateUrl: './warehouse-detail.component.html',
  styleUrls: ['./warehouse-detail.component.css']
})
export class WarehouseDetailComponent {

  warehouse: Warehouse | undefined;
  products: Product[] = [];
  currentStock: number = 0;

  constructor(
    private route: ActivatedRoute,
    private warehouseService: WarehouseService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getWarehouse();
  }

  getWarehouse(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.warehouseService.getWarehouse(id).subscribe(warehouse => {
      this.warehouse = warehouse;
      this.currentStock = warehouse.products.length;
      this.products = this.warehouse ? this.warehouse.products : [];
    });
  }

  goBack(): void {
    this.location.back();
  }

}
