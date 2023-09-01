import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Warehouse } from '../entities/warehouse';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  private warehouseUrl = environment.warehouseApiUrl;

  constructor(private http: HttpClient) { }

  getWarehouses(): Observable<Warehouse[]> {
    return this.http.get<Warehouse[]>(this.warehouseUrl);
  }

  getWarehouse(id: number): Observable<Warehouse> {
    const url = `${this.warehouseUrl}/${id}`;
    return this.http.get<Warehouse>(url);
  }

}
