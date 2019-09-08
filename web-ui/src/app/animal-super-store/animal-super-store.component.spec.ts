import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalSuperStoreComponent } from './animal-super-store.component';

describe('Table2Component', () => {
  let component: AnimalSuperStoreComponent;
  let fixture: ComponentFixture<AnimalSuperStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimalSuperStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimalSuperStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
