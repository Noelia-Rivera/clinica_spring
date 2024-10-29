package com.example.examenLP.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenLP.dao.PacienteDao;
import com.example.examenLP.entity.Paciente;
import com.example.examenLP.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteDao dao;
	
	@Override
	public Paciente create(Paciente p) {
		// TODO Auto-generated method stub
		return dao.create(p);
	}

	@Override
	public Paciente update(Paciente p) {
		// TODO Auto-generated method stub
		return dao.update(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Paciente> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
