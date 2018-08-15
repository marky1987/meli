package com.ml.clima.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRONOSTICO")
public class Pronostico implements Serializable {

	private static final long serialVersionUID = -6211764091530370949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "dia", nullable=false)
	private Integer dia;

	@Column(name = "descripcion", nullable=false)
	
	private String descripcion;

	
	public Pronostico() {
		super();
	}

	public Pronostico(long id, Integer dia, String descripcion) {
		super();
		this.id = id;
		this.dia = dia;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
