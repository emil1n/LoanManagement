import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanofficerListComponent } from './loanofficer-list.component';

describe('LoanofficerListComponent', () => {
  let component: LoanofficerListComponent;
  let fixture: ComponentFixture<LoanofficerListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoanofficerListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanofficerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
