package com.geppetto.daedalustest.service.serviceimpl;

import com.geppetto.daedalustest.dao.HospitalordersDao;
import com.geppetto.daedalustest.dto.HospitalordersDto;
import com.geppetto.daedalustest.exception.EntityNotFoundException;
import com.geppetto.daedalustest.model.Hospitalorders;
import com.geppetto.daedalustest.service.HospitalordersService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link HospitalordersService} interface.
* Provides services related to Hospitalorders, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class ExternalpatientsServiceImpl implements ExternalpatientsService {


    /**
     * Constructs a {@code ExternalpatientsServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param externalpatientsDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final ExternalpatientsDao externalpatientsDao;
  private final MongoTemplate mongoTemplate;

  public ExternalpatientsServiceImpl(ExternalpatientsDao  externalpatientsDao, MongoTemplate mongoTemplate) {
    this. externalpatientsDao =  externalpatientsDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Retrieves externalpatients by its ID.
     *
     * @param id The ID of the externalpatients to retrieve. Must not be {@code null}.
     * @return The externalpatients data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no externalpatients with the specified ID is found.
     */
  @Override
  public ExternalpatientsDto  getExternalpatientsById(String id) {
    log.info("Enter into getExternalpatientsById method");
    return externalpatientsDao.getExternalpatientsById(id)
    .map(externalpatients -> {
      ExternalpatientsDto externalpatientsDto = new ExternalpatientsDto();
      BeanUtils.copyProperties(externalpatients, externalpatientsDto);
      log.info("Exit from getExternalpatientsById method");
      return externalpatientsDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Creates new externalpatients.
     *
     * @param externalpatientsDto The {@link ExternalpatientsDto} to be created.
     * @return The created {@link ExternalpatientsDto}.
     */
  @Override
  public ExternalpatientsDto  createExternalpatients(ExternalpatientsDto externalpatientsDto) {
    log.info("Enter into createExternalpatients method");
    Externalpatients externalpatients = new Externalpatients();
  BeanUtils.copyProperties(externalpatientsDto, externalpatients);
  Externalpatients createdExternalpatients= externalpatientsDao.createExternalpatients(externalpatients);
  BeanUtils.copyProperties(createdExternalpatients, externalpatientsDto);
  log.info("Exit from createExternalpatients method");
  return externalpatientsDto;
  }
    
    /**
     * Deletes externalpatients by ID.
     *
     * @param id The ID of the externalpatients to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no externalpatients with the specified ID is found.
     */
  @Override
  public String  deleteExternalpatients(String id) {
    log.info("Enter into deleteExternalpatients method");
    return externalpatientsDao.getExternalpatientsById(id)
     .map(externalpatients -> {
     externalpatientsDao.deleteExternalpatients(id);
  log.info("Exit from deleteExternalpatients method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Updates existing externalpatients.
     *
     * @param externalpatientsDto The {@link ExternalpatientsDto} containing updated information.
     * @return The updated {@link ExternalpatientsDto}.
     * @throws EntityNotFoundException If no externalpatients with the specified ID is found.
     */
  @Override
  public ExternalpatientsDto  updateExternalpatients(ExternalpatientsDto externalpatientsDto) {
    log.info("Enter into updateExternalpatients method");
    return externalpatientsDao.getExternalpatientsById(externalpatientsDto.getId())
    .map(existingExternalpatients -> {
      BeanUtils.copyProperties(externalpatientsDto, existingExternalpatients);
      externalpatientsDao.createExternalpatients(existingExternalpatients);
      log.info("Exit from updateExternalpatients method");
      return externalpatientsDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + externalpatientsDto.getId()));
  }
    
    /**
     * Retrieves all externalpatients.
     *
     * @return A list of {@link ExternalpatientsDto} representing all externalpatients.
     */
  @Override
  public Page<ExternalpatientsDto>  getAllExternalpatients(int page, int size) {
    log.info("Enter into getAllExternalpatients method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Externalpatients> externalpatientsPage =externalpatientsDao.getAllExternalpatients(pageable);
    Page<ExternalpatientsDto>externalpatientsDtoPage = externalpatientsPage.map(externalpatients -> {
    ExternalpatientsDto externalpatientsDto = ExternalpatientsDto.builder().build();
    BeanUtils.copyProperties(externalpatients, externalpatientsDto);
    return externalpatientsDto;
    });
    log.info("Exit from getAllexternalpatientsmethod");
    return externalpatientsDtoPage;
  }
    

}
