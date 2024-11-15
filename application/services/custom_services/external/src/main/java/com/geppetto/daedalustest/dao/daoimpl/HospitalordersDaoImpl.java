package com.geppetto.daedalustest.dao.daoimpl;

import com.geppetto.daedalustest.repository.HospitalordersRepository;
import com.geppetto.daedalustest.dao.HospitalordersDao;

import java.util.Optional;
import com.geppetto.daedalustest.model.Externalpatients;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link HospitalordersDao} interface.
* Provides methods to interact with the {@link HospitalordersRepository} for CRUD operations on {@link Hospitalorders } entities.
*/
@Service
public class HospitalordersDaoImpl implements HospitalordersDao {

    private final ExternalpatientsRepository externalpatientsRepository;
    /**
     * Constructs a new {@code ExternalpatientsDaoImpl} with the specified repository.
     *
     * @param externalpatientsRepository The repository used for accessing {@link Externalpatients} entities. Must not be {@code null}.
     */
    public ExternalpatientsDaoImpl(ExternalpatientsRepository externalpatientsRepository) {
        this.externalpatientsRepository = externalpatientsRepository;
    }

    /**
     * Retrieves externalpatients by its ID.
     *
     * @param id The ID of the externalpatients to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the externalpatients if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Externalpatients> getExternalpatientsById(String id) {
        return externalpatientsRepository.findById(id);
    }


    /**
     * Creates new externalpatients.
     *
     * @param externalpatients The {@link Externalpatients} entity to create. Must not be {@code null}.
     * @return The created {@link Externalpatients} entity.
     */
    @Override
    public Externalpatients createExternalpatients(Externalpatients externalpatients) {
        return externalpatientsRepository.save(externalpatients);
    }


    /**
     * Deletes externalpatients by its ID.
     *
     * @param id The ID of the externalpatients to delete. Must not be {@code null}.
     */
    @Override
    public void deleteExternalpatients(String id) {
        externalpatientsRepository.deleteById(id);
    }


    /**
     * Retrieves externalpatients by its ID for update purposes.
     *
     * @param id The ID of the externalpatients to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the externalpatients if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Externalpatients> updateExternalpatients(String id) {
        return externalpatientsRepository.findById(id);
    }


     /**
     * Retrieves all externalpatients from the repository.
     *
     * @return A list of all {@link Externalpatients} entities.
     */
    @Override
    public Page<Externalpatients> getAllExternalpatients(Pageable pageable) {
        return externalpatientsRepository.findAll(pageable);
    }


}


