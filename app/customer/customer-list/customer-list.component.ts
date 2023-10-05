import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/shared/service/customer.service';
import { Router } from '@angular/router';
import { Customer } from 'src/app/shared/model/customer';
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

searchTerm='';
page:number=1;
pageSize=10;
  constructor(public customerService:CustomerService,private router:Router) { }

  ngOnInit(): void {
    console.log(" customer list component");
    this.customerService.getAllCustomerDetails();
  }
  updateCustomerDetails(vendordetails: Customer){
    console.log("updating...");
    console.log(customer);
    this.populateVendorDetails(customer);
    this.router.navigate(['/customer/edit', customer.customerId]);
    //Locaalhost:4200/vendordetails/edit/vendorId

  }

  //Delete
  deleteVendorDetails(_id:number){
    console.log("deleting...");
    if(confirm("Are you sure you want to delete this vendor?") == true){
      this.customerService.deleteCustomerDetails(_id)
      
      .subscribe(res=>{
        console.log(res);
        this.customerService.getAllCustomerDetails();
      },
      (error)=>{
        console.log(error);
      }
      )
    }
  }
  //Getting vendor data
  populateVendorDetails(customer: Customer){
    this.customerService.formData = Object.assign({}, customer);
  }


}
