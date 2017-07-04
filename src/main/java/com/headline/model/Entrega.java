package com.headline.model;

import java.time.LocalDate;

public class Entrega {

	private Compra compra;
	private String id;
	private LocalDate previsao;
	private Status status;

	public Entrega(Compra compra, String id, LocalDate previsao, Status status) {
		super();
		this.setCompra(compra);
		this.id = id;
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
