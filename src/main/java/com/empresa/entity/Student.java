package com.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlumno")
	private int id;

	@Column(name = "nombre")
	private String name;

	private String dni;

	@Column(name = "correo")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento")
	private Date BirthDay;

}
