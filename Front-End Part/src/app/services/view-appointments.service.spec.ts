import { TestBed } from '@angular/core/testing';

import { ViewAppointmentsService } from './view-appointments.service';

describe('ViewAppointmentsService', () => {
  let service: ViewAppointmentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewAppointmentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
