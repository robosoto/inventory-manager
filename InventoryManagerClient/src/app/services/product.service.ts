import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Product } from '../entities/product';
import { environment } from 'src/environments/environment.development';
import { ProductDto } from '../entities/productDto';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = environment.productApiUrl;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  getProduct(id: number): Observable<Product> {
    const url = `${this.productUrl}/${id}`;
    return this.http.get<Product>(url);
  }

  createProduct(product: ProductDto): Observable<any> {
    return this.http.post<ProductDto>(this.productUrl,
                                      product,
                                      this.httpOptions);
  }

  delete(id: number): Observable<Product> {
    const url = `${this.productUrl}/${id}`;
    return this.http.delete<Product>(url);
  }

}
