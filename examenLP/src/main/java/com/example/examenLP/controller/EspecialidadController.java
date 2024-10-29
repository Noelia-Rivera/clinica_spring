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

import com.example.examenLP.entity.Especialidad;
import com.example.examenLP.service.EspecialidadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {
		@Autowired
		private EspecialidadService service;
		
		@GetMapping
		public ResponseEntity<List<Especialidad>> readAll() {
			try {
				List<Especialidad> especialidades = service.readAll();
				if (especialidades.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(especialidades, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping
		public ResponseEntity<Especialidad> create(@Valid @RequestBody Especialidad esp) {
			try {
				Especialidad es = service.create(esp);
				return new ResponseEntity<>(es, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Especialidad> getEspecialidadId(@PathVariable Long id) {
			try {
				Especialidad es = service.read(id).get();
				return new ResponseEntity<>(es, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Especialidad> delEspecialidad(@PathVariable Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Long id, @Valid @RequestBody Especialidad esp) {
			Optional<Especialidad> es = service.read(id);
			if (es.isEmpty()) {
				return new ResponseEntity<>(service.update(esp), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
}
