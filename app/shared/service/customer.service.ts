import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Customer } from '../model/customer';
import { Observable } from 'rxjs';
import { Loan } from '../model/loan';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

   //declare variable
   formData: Customer= new Customer();

   //declaring of list
  customer: Customer[];

   //dependency injection 
  constructor(private httpClient:HttpClient) { }

  //list of loan
 loan:Loan[];

  getAllCustomerDetails():void{
    this.httpClient.get(environment.apiUrl+'/api/customer')
    .toPromise()
    .then(response=>{
      console.log(response);
      this.customer = response as Customer[];
    },
    error=>{
      console.log(error);
    }
    )
  }

  getAllCustomerDetailsList():Observable<any>{
    return this.httpClient.get(environment.apiUrl+'/api/customer');
  }

  //2.insert 
  insertCustomerDetails(customer:Customer):Observable<any>{
    return this.httpClient.post(environment.apiUrl+'/api/customer',this.customer);
  }

   //3.update 
   updateVendorDetails(customer: Customer):Observable<any>{
    return this.httpClient.put(environment.apiUrl+'/api/customer',customer);
  }

  //3.delete 
  deleteVendorDetails(vendorId:number){
    return this.httpClient.delete(environment.apiUrl+'/api/vendordetails/disable/'+vendorId);
  }

  getAllLoanTypes():void{
    this.httpClient.get(environment.apiUrl+'/api/loan')
    .toPromise()
    .then(response =>{
      console.log(response);
      this.loan=response as Loan[];
    }, error=>{
      console.log('error')
    })
  }



}
