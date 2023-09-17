import { Component, Input } from '@angular/core';
import { Product } from '../module/product';

@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.component.html',
  styleUrls: ['./viewdetails.component.css']
})
export class ViewdetailsComponent {
  @Input() product:Product
  constructor(){
    this.product=new Product('a','a','a','a',0,0);
  }
}
