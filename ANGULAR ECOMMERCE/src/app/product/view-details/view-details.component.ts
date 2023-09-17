import { Component, Input } from '@angular/core';
import { Product } from 'src/app/module/product';

@Component({
  selector: 'app-view-details',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.css']
})
export class ViewDetailsComponent {
  @Input() prod:Product
  constructor(){
    this.prod=new Product('a','a','a','a',0,0);
  }
}
