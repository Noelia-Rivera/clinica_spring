package com.example.examenLP.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenLP.dao.DiagnosticoDao;
import com.example.examenLP.entity.Diagnostico;
import com.example.examenLP.repository.DiagnosticoRepository;


@Component
public class DiagnosticoDaoImpl implements DiagnosticoDao{

	@Autowired
	private DiagnosticoRepository diagnosticoRepository;
	
	@Override
	public Diagnostico create(Diagnostico d) {
		// TODO Auto-generated method stub
		return diagnosticoRepository.save(d);
	}

	@Override
	public Diagnostico update(Diagnostico d) {
		// TODO Auto-generated method stub
		return diagnosticoRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		diagnosticoRepository.deleteById(id);
	}

	@Override
	public Optional<Diagnostico> read(Long id) {
		// TODO Auto-generated method stub
		return diagnosticoRepository.findById(id);
	}

	@Override
	public List<Diagnostico> readAll() {
		// TODO Auto-generated method stub
		return diagnosticoRepository.findAll();
	}

}
