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

import com.example.examenLP.entity.Diagnostico;
import com.example.examenLP.service.DiagnosticoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/diagnosticos")
@CrossOrigin(origins = "http://localhost:4200")
public class DiagnosticoController {
		@Autowired
		private DiagnosticoService service;
		
		@GetMapping
		public ResponseEntity<List<Diagnostico>> readAll() {
			try {
				List<Diagnostico> diagnosticos = service.readAll();
				if (diagnosticos.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping
		public ResponseEntity<Diagnostico> create(@Valid @RequestBody Diagnostico di) {
			try {
				Diagnostico d = service.create(di);
				return new ResponseEntity<>(d, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@GetMapping("/{id}")
		public ResponseEntity<Diagnostico> getDiagnosticoId(@PathVariable Long id) {
			try {
				Diagnostico d = service.read(id).get();
				return new ResponseEntity<>(d, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Diagnostico> delDiagnostico(@PathVariable Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateDiagnostico(@PathVariable Long id, @Valid @RequestBody Diagnostico di) {
			Optional<Diagnostico> d = service.read(id);
			if (d.isEmpty()) {
				return new ResponseEntity<>(service.update(di), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
}

