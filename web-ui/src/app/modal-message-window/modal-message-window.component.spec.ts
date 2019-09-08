import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalMessageWindowComponent } from './modal-message-window.component';

describe('ModalMessageWindowComponent', () => {
  let component: ModalMessageWindowComponent;
  let fixture: ComponentFixture<ModalMessageWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalMessageWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalMessageWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
