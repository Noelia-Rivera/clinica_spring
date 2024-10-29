package com.example.examenLP.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenLP.dao.EspecialidadDao;
import com.example.examenLP.entity.Especialidad;
import com.example.examenLP.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	private EspecialidadDao dao;
	
	@Override
	public Especialidad create(Especialidad e) {
		// TODO Auto-generated method stub
		return dao.create(e);
	}

	@Override
	public Especialidad update(Especialidad e) {
		// TODO Auto-generated method stub
		return dao.update(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
