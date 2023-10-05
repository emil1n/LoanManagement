import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoanofficerAddComponent } from './loanofficer-add/loanofficer-add.component';
import { LoanofficerEditComponent } from './loanofficer-edit/loanofficer-edit.component';
import { LoanofficerListComponent } from './loanofficer-list/loanofficer-list.component';



@NgModule({
  declarations: [LoanofficerAddComponent, LoanofficerEditComponent, LoanofficerListComponent],
  imports: [
    CommonModule
  ]
})
export class LoanofficerModule { }
