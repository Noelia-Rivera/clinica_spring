package com.example.examenLP.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pacientes")
public class Paciente {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "nombres", length = 50)
		private String nombres;
		@Column(name = "apellidos", length = 50)
		private String apellidos;
		@Column(name = "fecha_nacimiento")
		@Temporal(TemporalType.DATE)
		private Date fecha_nacimiento;
		@Column(name = "direccion", length = 100)
		private String direccion;
		@Column(name = "telefono", length = 9)
		private String telefono;
		@Column(name = "estado")
		private char estado;
		
		
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
		@JsonIgnore
		private Set<Consulta> consulta;
}
