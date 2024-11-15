import { Component, OnInit, ViewChild } from '@angular/core';
import { ExternalpatientService } from './externalpatient.service';





@Component({
  selector: 'app-externalpatient',
  templateUrl: './externalpatient.component.html',
  styleUrls: ['./externalpatient.component.scss'],
})

export class ExternalpatientComponent implements OnInit {
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
    paginationPageSize = 10;
 	page=1;
 	rowData: any[] = [];
 	rowIndex: Number = 0;




    constructor (
        private externalpatientService: ExternalpatientService,
    ) { }

    ngOnInit() {
        this.hospitalorders.created_by = sessionStorage.getItem('email') || ''; 
        this.investigations.created_by = sessionStorage.getItem('email') || ''; 
        this.externalpatients.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }


}