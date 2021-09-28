import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderMedicinesComponent } from './order-medicines.component';

describe('OrderMedicinesComponent', () => {
  let component: OrderMedicinesComponent;
  let fixture: ComponentFixture<OrderMedicinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderMedicinesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderMedicinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
