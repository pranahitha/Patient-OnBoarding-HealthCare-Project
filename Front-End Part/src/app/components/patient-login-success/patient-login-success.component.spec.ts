import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientLoginSuccessComponent } from './patient-login-success.component';

describe('PatientLoginSuccessComponent', () => {
  let component: PatientLoginSuccessComponent;
  let fixture: ComponentFixture<PatientLoginSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientLoginSuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientLoginSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
