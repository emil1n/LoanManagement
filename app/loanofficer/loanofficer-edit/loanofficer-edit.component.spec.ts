import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanofficerEditComponent } from './loanofficer-edit.component';

describe('LoanofficerEditComponent', () => {
  let component: LoanofficerEditComponent;
  let fixture: ComponentFixture<LoanofficerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoanofficerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanofficerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
