package com.geppetto.daedalustest.service;

import com.geppetto.daedalustest.dto.HospitalordersDto;
import org.springframework.data.domain.Page;

public interface HospitalordersService {

    ExternalpatientsDto  getExternalpatientsById(String id);

    ExternalpatientsDto  createExternalpatients(ExternalpatientsDto externalpatientsDto);

    String  deleteExternalpatients(String id);

    ExternalpatientsDto  updateExternalpatients(ExternalpatientsDto externalpatientsDto);

    Page<ExternalpatientsDto>  getAllExternalpatients(int page, int size);

}
