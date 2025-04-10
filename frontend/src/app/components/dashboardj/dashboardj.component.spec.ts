import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardjComponent } from './dashboardj.component';

describe('DashboardjComponent', () => {
  let component: DashboardjComponent;
  let fixture: ComponentFixture<DashboardjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardjComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
