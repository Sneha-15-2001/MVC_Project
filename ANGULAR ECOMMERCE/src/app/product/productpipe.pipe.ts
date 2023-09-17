import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../module/product';

@Pipe({
  name: 'category',
  pure:true,
})
export class ProductpipePipe implements PipeTransform {

  
    transform(productList:Product[],category:any)  {
      if(category=='all')
      return productList;
      else
      return productList.filter((product)=>product.category==category)
     }
  }


