import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoanofficerAddComponent } from './loanofficer-add/loanofficer-add.component';
import { LoanAddComponent } from './loan-add/loan-add.component';
import { LoanEditComponent } from './loan-edit/loan-edit.component';
import { LoanListComponent } from './loan-list/loan-list.component';



@NgModule({
  declarations: [LoanofficerAddComponent, LoanAddComponent, LoanEditComponent, LoanListComponent],
  imports: [
    CommonModule
  ]
})
export class LoanModule { }
