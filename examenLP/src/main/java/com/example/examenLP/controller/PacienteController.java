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

import com.example.examenLP.entity.Paciente;
import com.example.examenLP.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {
		@Autowired
		private PacienteService service;
		
		@GetMapping
		public ResponseEntity<List<Paciente>> readAll() {
			try {
				List<Paciente> pacientes = service.readAll();
				if (pacientes.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(pacientes, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping
		public ResponseEntity<Paciente> crear(@Valid @RequestBody Paciente pa) {
			try {
				Paciente p = service.create(pa);
				return new ResponseEntity<>(p, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Paciente> getPacienteId(@PathVariable Long id) {
			try {
				Paciente p = service.read(id).get();
				return new ResponseEntity<>(p, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Paciente> delPaciente(@PathVariable Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @Valid @RequestBody Paciente pa) {
			Optional<Paciente> p = service.read(id);
			if (p.isEmpty()) {
				return new ResponseEntity<>(service.update(pa), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
 		}
}
