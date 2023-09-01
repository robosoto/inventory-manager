import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { WarehousesComponent } from './warehouses/warehouses.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { WarehouseDetailComponent } from './warehouse-detail/warehouse-detail.component';
import { ProductCreateComponent } from './product-create/product-create.component';

const routes: Routes = [
  { path: '', redirectTo: '/warehouses', pathMatch: 'full' },
  { path: 'products', component: ProductsComponent },
  { path: 'detail/:id', component: ProductDetailComponent },
  { path: 'product/new', component: ProductCreateComponent },
  { path: 'warehouses', component: WarehousesComponent },
  { path: 'warehouse/:id', component: WarehouseDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }