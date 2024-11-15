import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExternalpatientComponent } from './externalpatient.component';
import { ExternalpatientService } from './externalpatient.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ExternalpatientComponent } from './externalpatient.component';
import { NgbPaginationModule, NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';


describe('ExternalpatientComponent', () => {
  let component: ExternalpatientComponent;
  let fixture: ComponentFixture<ExternalpatientComponent>;
  let service: ExternalpatientService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
        NgbPaginationModule,
      ],
      declarations: [ ExternalpatientComponent ],
      providers: [ ExternalpatientService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExternalpatientComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(ExternalpatientService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.hospitalorders.created_by).toEqual(mockEmail);
    expect(component.investigations.created_by).toEqual(mockEmail);
    expect(component.externalpatients.created_by).toEqual(mockEmail);

  });
  


});