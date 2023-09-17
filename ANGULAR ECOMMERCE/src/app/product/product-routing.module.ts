import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product.component';
import { CreateComponent } from './create/create.component';
import { ViewComponent } from './view/view.component';
import { SearchComponent } from './search/search.component';
import { EditComponent } from './edit/edit.component';
import { DeleteComponent } from './delete/delete.component';

const routes: Routes = [
    {
      path:'product',
      component:ProductComponent,children:
      [{
      path:'create',
      component:CreateComponent
    },{
      path:'view',
      component:ViewComponent
    },
    {
      path:'search',
      component:SearchComponent
    },
  {
    path:'edit/:id',
    component:EditComponent
  },{
    path:'delete/:id',
    component:DeleteComponent
  },],},
  ];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
