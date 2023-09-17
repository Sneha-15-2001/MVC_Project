import { Component } from '@angular/core';
import { Product } from 'src/app/module/product';
import { categories } from 'src/app/module/productList';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {
product:Product;
productList:Product[];
categoriesList:string[];
hasError:boolean=false;
errorMessage:string='';
constructor(private eService:ServicesService){
  this.productList=this.eService.getProductList();
  this.product=new Product('','','','',0,0);
  this.categoriesList=categories;
}
validate(data:string)
{
  if(data === 'default') 
    this.hasError=true
    else
    this.hasError=false
}
dataSubmited(){
  console.log(this.product);
  const result=this.eService.addProduct(this.product);
  if(result==='duplicate'){
   this.errorMessage='Product with the same ID already exists!';
  }
  else{
    this.errorMessage='';
  }
}
}
