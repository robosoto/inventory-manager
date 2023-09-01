import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

import { Product } from '../entities/product';
import { ProductService } from '../services/product.service';
import { ProductDto } from '../entities/productDto';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent {

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private productService: ProductService
  ) {}

  productForm = this.fb.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    warehouseId: ['', Validators.required]
  });

  submitted = false;

  handleSubmit($event: any) {
    console.log("handle submit")
    $event.preventDefault();
    this.submitted = true;
    const productDto: ProductDto = {
      name: this.productForm.value.name as unknown as string,
      description: this.productForm.value.description as unknown as string,
      warehouseId: this.productForm.value.warehouseId as unknown as number
    }
    console.log(productDto)
    this.productService.createProduct(productDto).subscribe();
    // this.router.navigate([`/warehouse/${this.productForm.value.warehouseId}`]);
  }

}
