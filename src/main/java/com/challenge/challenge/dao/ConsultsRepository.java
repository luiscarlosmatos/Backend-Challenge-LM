package com.challenge.challenge.dao;

import com.challenge.challenge.entity.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultsRepository extends JpaRepository<Consult, Long> {
    List<Consult> findByPatientId(Long id);
}
