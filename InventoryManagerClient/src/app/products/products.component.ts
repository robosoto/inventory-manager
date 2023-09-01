import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { Product } from '../entities/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  products: Product[] = [];
  products$!: Observable<Product[]>;
  selectedId!: number;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) {}

  getProducts(): void {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

  delete(product: Product): void {
    if(confirm("Proceed with deletion of " + product.name + " (id: " + product.id + ")?")) {
      this.products = this.products.filter(p => p !== product);
      this.productService.delete(product.id).subscribe();
    }
  }

  ngOnInit(): void {
    this.getProducts();
    this.products$ = this.route.paramMap.pipe(
      switchMap(params => {
        this.selectedId = Number(params.get('id'));
        return this.productService.getProducts()
      })
    )
  }

}
