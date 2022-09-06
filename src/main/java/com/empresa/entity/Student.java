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
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Pattern(regexp = "[a-zA-ZáéíóúñüÁÉÍÓÚÑÜ\\s]{2,20}", message = "El nombre es de 2 a 20 caracteres")
	private String name;

	@Pattern(regexp = "[0-9]{8}", message = "El dni tiene 8 dígitos")
	private String dni;

	@Pattern(regexp = "[i][0-9]{9}(@cibertec.edu.pe)", message = "Ingrese un correo de Cibertec")
	@Column(name = "correo")
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento")
	private Date BirthDay;

}
