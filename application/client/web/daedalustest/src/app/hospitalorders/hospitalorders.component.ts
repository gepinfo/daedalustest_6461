import { Component, OnInit, ViewChild } from '@angular/core';
import { HospitalordersService } from './hospitalorders.service';





@Component({
  selector: 'app-hospitalorders',
  templateUrl: './hospitalorders.component.html',
  styleUrls: ['./hospitalorders.component.scss'],
})

export class HospitalordersComponent implements OnInit {
    columnDefs: any = [{ headerName: 'orderid', field: 'orderid'  },{ headerName: 'specimen no', field: 'specimentno'  },{ headerName: 'patient id', field: 'patientid'  },{ headerName: 'facility', field: 'facility'  },{ headerName: 'episode type', field: 'episodetype'  },{ headerName: 'episode id', field: 'episodeid'  },{ headerName: 'doctor', field: 'doctor'  },{ headerName: 'type', field: 'type'  },{ headerName: 'code', field: 'code'  },{ headerName: 'ps', field: 'ps'  },];
    public hospitalorders:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        orderid: '',
        specimentno: '',
        patientid: '',
        facility: '',
        episodeid: '',
        episodetype: '',
        doctor: '',
        type: '',
        code: '',
        ps: '',
    }
    public investigations:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        testcode: '',
        description: '',
        dte: '',
    }
    public externalpatients:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        extpatients: '',
        patientname: '',
        locpatientname: '',
        gender: '',
        dob: '',
        source: '',
        description: '',
        pretix: '',
        sourcepatientid: '',
        idno: '',
    }
    gridApi: any;
 	gridColumnApi: any;
 	rowSelection: "single" | "multiple" | undefined = 'single';
 	defaultColDef = { editable: false, sortable: true, resizable: true, filter: true };
 	paginationPageSize = 10;
 	rowData: any[] = [];
 	rowIndex: Number = 0;




    constructor (
        private hospitalordersService: HospitalordersService,
    ) { }

    ngOnInit() {
        this.hospitalorders.created_by = sessionStorage.getItem('email') || ''; 
        this.investigations.created_by = sessionStorage.getItem('email') || ''; 
        this.externalpatients.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }
    onGridReady(params:any) {
        this.gridApi = params.api;
        this.gridApi.sizeColumnsToFit();
        this.gridColumnApi = params.columnApi;
    }


}