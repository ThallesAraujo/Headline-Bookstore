package com.headline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Entrega {
	
	@OneToOne
	private Compra compra;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String id;
	
	private LocalDate previsao;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Entrega(){}
	
	public Entrega(Compra compra, LocalDate previsao, Status status) {
		super();
		this.setCompra(compra);
		this.previsao = previsao;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public enum Status {
		ENTREGUE, EM_TRANSPORTE, ATRASADA;
	}

}
