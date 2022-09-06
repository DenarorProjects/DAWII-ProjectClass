package com.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicamento")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMedicamento")
	private int id;

	@Pattern(regexp = "[A-Za-z0-9 ]{3,50}", message = "El nombre debe tener entre 3 y 50 caracteres")
	@Column(name = "nombre")
	private String name;

	@Max(value = 1000, message = "El precio no debe ser mayor a 1000")
	@Min(value = 1, message = "El precio no debe ser menor a 1")
	@Column(name = "precio")
	private double price;

	@Max(value = 1000, message = "El stock no debe ser mayor a 1000")
	@Min(value = 1, message = "El stock no debe ser menor a 1")
	private int stock;

	@Pattern(regexp = "[A-Za-z0-9 ]{3,50}", message = "El laboratorio debe tener entre 3 y 50 caracteres")
	@Column(name = "laboratorio")
	private String laboratory;
}
