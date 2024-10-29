package com.example.examenLP.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenLP.dao.ConsultaDao;
import com.example.examenLP.entity.Consulta;
import com.example.examenLP.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaDao dao;
	
	@Override
	public Consulta create(Consulta c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Consulta update(Consulta c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
