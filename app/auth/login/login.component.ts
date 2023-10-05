import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {User} from 'src/app/shared/models/user'
import { Router } from '@angular/router';
import {AuthService} from 'src/app/shared/services/auth.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
//declare variables
loginForm!:FormGroup;
isSubmitted:boolean=false;
error:string=''
loginUser?:User=new User();


constructor(private formBuilder:FormBuilder,
  private authService:AuthService,
  private router:Router) { }

ngOnInit(): void {
  //create a reactive form
  this.loginForm=this.formBuilder.group({
    userName:['',[Validators.required]],
    password:['',[Validators.required]]
  });
}

get formControls(){
  return this.loginForm.controls;
}

loginCredentials():void{
  this.isSubmitted=true;
  if(this.loginForm.invalid){
    this.error="Please enter user name and password";
    return;
  }
  
  if(this.loginForm.valid){
    this.error="";
    console.log(this.loginForm.value);
    this.authService.loginverify(this.loginForm.value)
    .subscribe(response=>{
      console.log(response);

      if(response==null){
        this.error="Invalid user name and password";
      }
      if(response.data.role===1){
        //sessiuon storage
      sessionStorage.setItem("USER_NAME",response.data.UserName)
      localStorage.setItem("ROLE_ID",response.data.role)


      localStorage.setItem("TOKEN",response.data.ACCESSTOKEN)
      console.log(sessionStorage.getItem("USER_NAME"));
        this.router.navigate(['assetMaster/list']);
      }
      if(response.data.role===2){
        //sessiuon storage
      sessionStorage.setItem("USER_NAME",response.data.UserName)
      localStorage.setItem("ROLE_ID",response.data.role)


      localStorage.setItem("TOKEN",response.data.ACCESSTOKEN)
      console.log(sessionStorage.getItem("USER_NAME"));
        this.router.navigate(['purchase/view']);
      }
      if(response.data.role===3){
        //sessiuon storage
      sessionStorage.setItem("USER_NAME",response.data.UserName)
      localStorage.setItem("ROLE_ID",response.data.role)


      localStorage.setItem("TOKEN",response.data.ACCESSTOKEN)
      console.log(sessionStorage.getItem("USER_NAME"));
        this.router.navigate(['assetDetails/list']);
      }
      if(response.data.role===4){
        //sessiuon storage
      sessionStorage.setItem("USER_NAME",response.data.UserName)
      localStorage.setItem("ROLE_ID",response.data.role)


      localStorage.setItem("TOKEN",response.data.ACCESSTOKEN)
      console.log(sessionStorage.getItem("USER_NAME"));
        this.router.navigate(['vendorDetails/list']);
      }
      

    })
   
  }
  
}

}
