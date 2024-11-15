package com.geppetto.daedalustest.dao;

import java.util.Optional;
import com.geppetto.daedalustest.model.Externalpatients;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface HospitalordersDao {

    Optional<Externalpatients> getExternalpatientsById(String id);

    Externalpatients createExternalpatients(Externalpatients externalpatients);

    void deleteExternalpatients(String id);

    Optional<Externalpatients> updateExternalpatients(String id);

    Page<Externalpatients> getAllExternalpatients(Pageable pageable);

}

