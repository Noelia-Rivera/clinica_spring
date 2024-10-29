package com.example.examenLP.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenLP.dao.ConsultaDao;
import com.example.examenLP.entity.Consulta;
import com.example.examenLP.repository.ConsultaRepository;

@Component
public class ConsultaDaoImpl implements ConsultaDao{

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public Consulta create(Consulta c) {
		// TODO Auto-generated method stub
		return consultaRepository.save(c);
	}

	@Override
	public Consulta update(Consulta c) {
		// TODO Auto-generated method stub
		return consultaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		consultaRepository.deleteById(id);
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return consultaRepository.findById(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return consultaRepository.findAll();
	}

}
