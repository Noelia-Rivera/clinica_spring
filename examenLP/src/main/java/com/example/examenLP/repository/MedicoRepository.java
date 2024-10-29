package com.example.examenLP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenLP.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
