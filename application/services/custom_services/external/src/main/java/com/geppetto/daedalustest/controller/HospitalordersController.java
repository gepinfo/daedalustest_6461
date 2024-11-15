package com.geppetto.daedalustest.controller;

import com.geppetto.daedalustest.dto.HospitalordersDto;
import com.geppetto.daedalustest.service.HospitalordersService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Hospitalorders
* Provides endpoints to create, update, delete, retrieve, and search for Hospitalorders,
* as well as to handle file uploads and downloads associated with Hospitalorders.
*/
@RestController
@RequestMapping("/external")
@RequiredArgsConstructor
@Slf4j
public class ExternalpatientsController {

   private final ExternalpatientsService externalpatientsService; 


@GetMapping("/{id}")
public ResponseEntity<ExternalpatientsDto> getExternalpatientsById(@PathVariable String id) {
    log.info("Enter into getExternalpatientsById method");
    ResponseEntity<ExternalpatientsDto> response =ResponseEntity.status(HttpStatus.OK).body(externalpatientsService.getExternalpatientsById(id));
    log.info("Exit from getExternalpatientsById method");
    return response;
}

@PostMapping
public ResponseEntity<ExternalpatientsDto> createExternalpatients(@Valid @RequestBody ExternalpatientsDto externalpatientsDto) {
    log.info("Enter into createExternalpatients method");
    ResponseEntity<ExternalpatientsDto> response =  ResponseEntity.status(HttpStatus.OK).body(externalpatientsService.createExternalpatients(externalpatientsDto));
    log.info("Exit from createExternalpatients method");
    return response;
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteExternalpatients(@PathVariable String id) {
    log.info("Enter into deleteExternalpatients method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(externalpatientsService.deleteExternalpatients(id));
    log.info("Exit from deleteExternalpatients method");
    return response;
}

@PutMapping
public ResponseEntity<ExternalpatientsDto> updateExternalpatients(@Valid @RequestBody ExternalpatientsDto externalpatientsDto) {
    log.info("Enter into updateExternalpatients method");
    ResponseEntity<ExternalpatientsDto> response = ResponseEntity.status(HttpStatus.OK).body(externalpatientsService.updateExternalpatients(externalpatientsDto));
    log.info("Exit from updateExternalpatients method");
    return response;
}

@GetMapping
public ResponseEntity<Page<ExternalpatientsDto>> getAllExternalpatients(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllExternalpatients method");
    Page<ExternalpatientsDto>externalpatientsDtoPage = externalpatientsService.getAllExternalpatients(page, size);
    log.info("Exit from getAllExternalpatients method");
    return new ResponseEntity<>(externalpatientsDtoPage, HttpStatus.OK);
}

   
}
