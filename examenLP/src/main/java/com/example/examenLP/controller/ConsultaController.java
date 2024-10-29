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

import com.example.examenLP.entity.Consulta;
import com.example.examenLP.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaController {
		@Autowired
		private ConsultaService service;
		
		@GetMapping
		public ResponseEntity<List<Consulta>> readAll() {
			try {
				List<Consulta> consultas = service.readAll(); 
				if (consultas.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(consultas, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping
		public ResponseEntity<Consulta> crear(@Valid @RequestBody Consulta con) {
			try {
				Consulta c = service.create(con);
				return new ResponseEntity<>(c, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Consulta> getConsultaId(@PathVariable Long id) {
			try {
				Consulta c = service.read(id).get();
				return new ResponseEntity<>(c, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Consulta> delConsulta(@PathVariable Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
		@PutMapping("/{id}")
		public ResponseEntity<?> updateConsulta(@PathVariable Long id, @Valid @RequestBody Consulta con) {
			Optional<Consulta> c =service.read(id);
			if (c.isEmpty()) {
				return new ResponseEntity<>(service.update(con), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
}
