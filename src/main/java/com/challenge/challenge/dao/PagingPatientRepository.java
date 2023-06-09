package com.challenge.challenge.dao;

import com.challenge.challenge.dto.SpecialityWithMaxPatientsDTO;
import com.challenge.challenge.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PagingPatientRepository extends PagingAndSortingRepository<Patient, Long>{

    Optional<Patient> findByName(String name);

    @Query(nativeQuery = true,
            value = "select specialityName, count(*) as numberOfPatients " +
                    "from (select distinct consult_speciality as specialityName, patient_id " +
                    "      from consults) A " +
                    "group by A.specialityName " +
                    "having count(*) > :minCount ")
    List<SpecialityWithMaxPatientsDTO> findSpecialityWithMaxPatients(@Param("minCount") int minCount);

}