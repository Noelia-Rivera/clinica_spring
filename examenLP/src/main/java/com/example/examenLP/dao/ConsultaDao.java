package com.example.examenLP.dao;

import java.util.List;
import java.util.Optional;

import com.example.examenLP.entity.Consulta;

public interface ConsultaDao {
	Consulta create(Consulta c);
	Consulta update(Consulta c);
	void delete(Long id);
	Optional<Consulta> read(Long id);
	List<Consulta> readAll();
}
