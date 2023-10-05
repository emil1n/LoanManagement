import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})
export class CustomerAddComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  addCustomerDetails(form:NgForm){
    console.log("inserting...");
    this.customerService.insertCustomerDetails(form.value)
    .subscribe(res=>{
      console.log(res);
    },
    (error)=>{
      console.log(error);
    }
    )
  }

  onSubmit(form:NgForm){
    console.log("inserting...");

    //insert employee

    this.addCustomerDetails(form)

    //reset
    form.reset();

    //navigate
    this.router.navigate(['/customer/list']);
  }


}
