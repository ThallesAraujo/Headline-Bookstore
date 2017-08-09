package com.headline.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Entrega implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	private Compra compra;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private LocalDate previsao;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Entrega(){}


	public LocalDate getPrevisao() {
		return previsao;
	}

	public void setPrevisao(LocalDate previsao) {
		this.previsao = previsao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public Integer getId() {
		return this.id;
	}

}
