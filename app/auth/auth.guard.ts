import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router:Router,private toastr: ToastrService){

  }
  canActivate(
    next: ActivatedRouteSnapshot
   ) :boolean{
    // if false redirect to login else show authorized page
    //check role:currentRole vs expected role
    //           localStorage   app.routing.module
    const currentRole=localStorage.getItem("ROLE_ID");
    const expectedRole=next.data.role;

    if(currentRole!==expectedRole){
          this.toastr.error("Unauthorized access");
          localStorage.removeItem("USER_NAME");
          sessionStorage.removeItem("USER_NAME");
          sessionStorage.removeItem("ROLE_ID");
          localStorage.removeItem("TOKEN");
      this.router.navigate(['auth/login']);
      return false;
    }


    return true;
  }
}
