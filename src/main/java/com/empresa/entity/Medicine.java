package com.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "nombre")
	private String name;

	@Column(name = "precio")
	private double price;

	private int stock;

	@Column(name = "laboratorio")
	private String laboratory;
}
