package com.example.examenLP.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenLP.dao.EspecialidadDao;
import com.example.examenLP.entity.Especialidad;
import com.example.examenLP.repository.EspecialidadRepository;


@Component
public class EspecialidadDaoImpl implements EspecialidadDao{

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Especialidad create(Especialidad e) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(e);
	}

	@Override
	public Especialidad update(Especialidad e) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

}
