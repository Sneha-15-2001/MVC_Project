import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { CreateComponent } from './create/create.component';
import { SearchComponent } from './search/search.component';
import { ViewComponent } from './view/view.component';
import { ProductComponent } from './product.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProddetailDirective } from './proddetail.directive';
import { ProductpipePipe } from './productpipe.pipe';
import { EditComponent } from './edit/edit.component';
import { DeleteComponent } from './delete/delete.component';
import { ViewDetailsComponent } from './view-details/view-details.component';


@NgModule({
  declarations: [ProductComponent,
    CreateComponent,
    SearchComponent,
    ViewComponent,
    ProductDetailsComponent,
    ProddetailDirective,
    ProductpipePipe,
    EditComponent,
    DeleteComponent,
    ViewDetailsComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,AppRoutingModule,
    FormsModule,ReactiveFormsModule
  ],
  exports:[ProductComponent]
})
export class ProductModule { }
