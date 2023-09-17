import { Directive, ElementRef, HostListener, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appProddetail]'
})
export class ProddetailDirective implements OnInit {

  @Input() category:any;

  constructor(private e1:ElementRef,private render:Renderer2) { 
    this.render.setStyle(this.e1.nativeElement,'background-color','green')
    this.render.setStyle(this.e1.nativeElement,'color','black')

  }
ngOnInit(): void {
    if(this.category=='MOBILE')
    { 
      this.render.setStyle(this.e1.nativeElement,'background-color','White')
     

    }
    else if(this.category=='CAMERA')
    
      { 
        this.render.setStyle(this.e1.nativeElement,'background-color','Thistle')
        this.render.setStyle(this.e1.nativeElement,'color','black')

      }
    else if(this.category=="CHOCOLATE")
    { 
      this.render.setStyle(this.e1.nativeElement,'background-color','Plum')
      this.render.setStyle(this.e1.nativeElement,'color','black')


    }
    else if(this.category=="GADGETS")
    { 
      this.render.setStyle(this.e1.nativeElement,'background-color','Orchid')
      this.render.setStyle(this.e1.nativeElement,'color','black')


    }
    else if(this.category=="LAPTOP")
    { 
      this.render.setStyle(this.e1.nativeElement,'background-color','#cf71af')
      this.render.setStyle(this.e1.nativeElement,'color','black')
     


    }
  }
  @HostListener('mouseover')
    mouseover(){
      this.render.setStyle(this.e1.nativeElement,'opacity','0.5')
      
    }
  @HostListener('mouseout')
  mouseout(){
    this.render.setStyle(this.e1.nativeElement,'opacity','1')
   
  }

}
