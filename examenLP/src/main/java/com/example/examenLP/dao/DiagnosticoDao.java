package com.example.examenLP.dao;

import java.util.List;
import java.util.Optional;

import com.example.examenLP.entity.Diagnostico;

public interface DiagnosticoDao {
	Diagnostico create(Diagnostico d);
	Diagnostico update(Diagnostico d);
	void delete(Long id);
	Optional<Diagnostico> read(Long id);
	List<Diagnostico> readAll();
}
