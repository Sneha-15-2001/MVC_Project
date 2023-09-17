import { Component,Input } from '@angular/core';
import { Product } from 'src/app/module/product';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  @Input() product:Product
  constructor(private eService:ServicesService){
    this.product=new Product('a','a','a','a',0,0);
  }

  onDeleteClick(productId:any){
    this.eService.deleteProduct(productId);
      
    
    }
}

