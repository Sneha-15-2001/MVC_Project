import { Component } from '@angular/core';
import { Product } from 'src/app/module/product';
import { categories, products } from 'src/app/module/productList';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  
  prodList:Product[];
  categoriesList:string[];
  category='all'
  msg="";
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
searchProduct(){
  console.log(this.msg);
  this.selectedProduct=this.eService.searchProductByName(this.msg.toLowerCase());
  console.log(this.selectedProduct);
  if(!this.selectedProduct){
    this.a="Not Product Found";
  }
  else{
    this.a='';
  }
 
}
onDeleteClick(productId:any){
this.eService.deleteProduct(productId);
  this.selectedProduct=undefined;

}
      
}

