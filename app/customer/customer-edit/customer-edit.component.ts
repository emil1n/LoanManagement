import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CustomerService } from 'src/app/shared/service/customer.service'

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {

  constructor(public customerService:CustomerService,private router:Router) { }

  ngOnInit(): void {
  }
  editCustomerDetails(form?:NgForm){
    console.log("updating...");
    this.customerService.updateCustomerDetails(form.value)
    .subscribe(res=>{
      console.log(res);
    },
    (error)=>{
      console.log(error);
    }
    )
  }

  onSubmit(form?:NgForm){
    console.log("inserting...");

    //insert vendor
    this.editCustomerDetails(form)

    //reset
    form.reset();

    //navigate
    this.router.navigate(['/customer/list']);
  }



}
