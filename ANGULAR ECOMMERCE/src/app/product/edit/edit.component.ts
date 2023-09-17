import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ActivatedRoute } from '@angular/router';

import { ServicesService } from 'src/app/services/services.service';

import { Observable } from 'rxjs'; // Import Observable

 

@Component({

  selector: 'app-edit',

  templateUrl: './edit.component.html',

  styleUrls: ['./edit.component.css']

})

export class EditComponent implements OnInit {
price:FormControl;
quantity:FormControl;
  editProductForm: FormGroup;

  productId: any;

  productdetails: any;
  hasError:boolean=false;

 

  constructor(private route: ActivatedRoute, private eService: ServicesService) {
    this.price=new FormControl('',[Validators.required,Validators.min(1)]),
    this.quantity=new FormControl('',[Validators.required,Validators.min(1)]),
    this.editProductForm = new FormGroup({

      name: new FormControl({ value: '', disabled: true }),

      description: new FormControl({ value: '', disabled: true }),

      id: new FormControl({ value: '', disabled: true }),

      category: new FormControl({ value: '', disabled: true }),

      price:this.price,

      quantity:this.quantity,

    });

  }

 

  ngOnInit(): void {

    this.route.params.subscribe((params) => {

      this.productId = params['id'];

      console.log(this.productId);

 

      const product=this.eService.getProductListById(this.productId) // Define the type of product

        if (product) {

          this.productdetails = product;

          this.editProductForm.patchValue({

id: this.productdetails.id,

name: this.productdetails.name,

            description: this.productdetails.description,

            category: this.productdetails.category,

            price: this.productdetails.price,

            quantity: this.productdetails.quantity,

          });

        }

      });

    

  }
  validate(data:string)
  {
    if(data === 'default') 
      this.hasError=true
      else
      this.hasError=false
  }
 

  updateProduct() {
if(this.editProductForm){
    const updatedProduct = this.editProductForm.value;

    console.log('Updated Product:', updatedProduct.price);
    this.eService.updateProducts(updatedProduct,this.productId);

  }
  }
}