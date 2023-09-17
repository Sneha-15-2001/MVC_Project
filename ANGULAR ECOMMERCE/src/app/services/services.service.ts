import { Injectable } from '@angular/core';
import{ Observable, of} from 'rxjs';
import { Product } from '../module/product';
import { products } from '../module/productList';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  constructor() { 
    this.productList=products;
  }
  private productList:Product[]=[];
  addProduct(product:Product){
    const existingProduct=this.productList.find(p=>p.id===product.id);
    if(!existingProduct){
    
    this.productList.push(product);
    return '';
    }else{
       console.error('Product with same ID already exists:',existingProduct);
       return 'duplicate';
    }
    
    console.log(this.productList);
  }
  getProductList():Product[]{
    return this.productList;
  }
 searchProductByName(name:string):Product|undefined{
  console.log(name)
  return this.productList.find(product=>product.name.toLowerCase()===name);
  
 }
 deleteProduct(prodId:any){
  const index=this.productList.findIndex((product)=>product.id===prodId);
  if(index!==-1)
  this.productList.splice(index,1);

 }
 getProductListById(prodId:any){
  return this.productList.find(product=>product.id===prodId);

 }
updateProducts(updatedProduct:Product,id:any){
  const index=this.productList.findIndex((product)=>product.id===id);
  if(index!==-1){
    this.productList[index]={...this.productList[index],...updatedProduct};
    console.log('Updated Product:',this.productList[index]);
  }
  
}
}