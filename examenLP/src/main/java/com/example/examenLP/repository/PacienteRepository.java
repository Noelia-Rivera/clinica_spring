package com.example.examenLP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenLP.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
