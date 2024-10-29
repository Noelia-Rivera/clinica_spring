package com.example.examenLP.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenLP.entity.Medico;
import com.example.examenLP.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {
		@Autowired
		private MedicoService service;
		
		@GetMapping
		public ResponseEntity<List<Medico>> readAll() {
			try {
				List<Medico> medicos = service.readAll();
				if (medicos.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(medicos, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@PostMapping
		public ResponseEntity<Medico> create(@Valid @RequestBody Medico me) {
			try {
				Medico m = service.create(me);
				return new ResponseEntity<>(m, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Medico> getMedicoId(@PathVariable Long id) {
			try {
				Medico m = service.read(id).get();
				return new ResponseEntity<>(m, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Medico> delMedico(@PathVariable Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @Valid @RequestBody Medico me) {
			Optional<Medico> m = service.read(id);
			if (m.isEmpty()) {
				return new ResponseEntity<>(service.update(me), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
}
