import { Component } from '@angular/core';
import { Product } from 'src/app/module/product';
import { categories, products } from 'src/app/module/productList';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent {
  
  prodList:Product[];
  categoriesList:string[];
  category='all'
  msg='';
  selectedProduct:Product|undefined;
  hasError:boolean=false;
  a='';
  constructor(private eService:ServicesService){
    this.categoriesList=categories;
    this.prodList=products;
    this.a='';
    
  }
  validate(data:string)
{
  if(data === 'default') 
    this.hasError=true
    else
    this.hasError=false
}
onDeleteClick(productId:any){
  this.eService.deleteProduct(productId);
    
  
  }
}
