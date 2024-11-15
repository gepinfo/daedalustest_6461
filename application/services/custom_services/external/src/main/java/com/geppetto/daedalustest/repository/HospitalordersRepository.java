package com.geppetto.daedalustest.repository;

import com.geppetto.daedalustest.model.Hospitalorders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface HospitalordersRepository extends MongoRepository<Hospitalorders,String>  {
    
    Page<Hospitalorders> findAll(Pageable pageable);

}
