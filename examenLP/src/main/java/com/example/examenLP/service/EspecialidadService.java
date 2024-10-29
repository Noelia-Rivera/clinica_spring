package com.example.examenLP.service;

import java.util.List;
import java.util.Optional;

import com.example.examenLP.entity.Especialidad;


public interface EspecialidadService {
	Especialidad create(Especialidad e);
	Especialidad update(Especialidad e);
	void delete(Long id);
	Optional<Especialidad> read(Long id);
	List<Especialidad> readAll();
}
