import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
//import { ProductComponent } from './product/product.component';
import { ProductModule } from './product/product.module';

import { ServicesService } from './services/services.service';
import { CustomerComponent } from './customer/customer.component';


@NgModule({
  declarations: [
    
    AppComponent,
    MenuComponent,
    CustomerComponent,
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ProductModule
  ],
  providers: [ServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
