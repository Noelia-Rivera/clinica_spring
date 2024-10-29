package com.example.examenLP.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenLP.dao.MedicoDao;
import com.example.examenLP.entity.Medico;
import com.example.examenLP.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoDao dao;
	
	@Override
	public Medico create(Medico m) {
		// TODO Auto-generated method stub
		return dao.create(m);
	}

	@Override
	public Medico update(Medico m) {
		// TODO Auto-generated method stub
		return dao.update(m);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Medico> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Medico> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
