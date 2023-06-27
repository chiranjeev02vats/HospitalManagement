package com.example.Hospital.Dal;

import com.example.Hospital.Entity.HospitalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<HospitalEntity,Long> {

    @Query(value ="Select s from HospitalEntity where isActive =:isActive")
    List<HospitalEntity> getAllActivePatients(Boolean isActive);

    @Query(value ="Select s from HospitalEntity where status =:status")
    List<HospitalEntity> getAllDischargedPatients(String status);
}
