import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from '/customer/customer.component';
import { LoanComponent} from '/loan/loan.component';
import { LoanOfficer } from './loanofficer/loanofficer.component'
import {AuthComponent} from './src/app/auth/auth.component';
import { SharedComponent } from './shared/shared.component';
const routes: Routes = [

  {
    path:'',redirectTo:'auth/login',pathMatch:'full'
  },
  {path:'customer',component:CustomerComponent,
loadChildren:()=>import('./customer/customer.module').then(x=>x.CustomerModule)
},
  //Lazy loading
  {path:'loan',component:LoanComponent,
  loadChildren:()=>import('./loan/loan.module').then(x=>x.LoanModule)
},
{path:'loanofficer',component:LoanOfficerComponent,
  loadChildren:()=>import('./loanofficer/loanofficer.module').then(x=>x.loanofficerModule)
},
{path:'auth',component:AuthComponent,
loadChildren:()=>import('./auth/auth.module').then(x=>x.AuthModule)
},
{path:'shared',component:SharedComponent,
loadChildren:()=>import('./shared/shared.module').then(x=>x.SharedModule)
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
