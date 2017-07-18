package com.headline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Promocao {
	
	@Id
	private String id;

	@ManyToOne
	private Produtor produtor;
	
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	public Promocao(){}

	public Promocao(Produtor produtor, LocalDate validade, Tipo tipo) {
		super();
		this.produtor = produtor;
		this.validade = validade;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public enum Tipo {
		FRETE, DESCONTO;
	}

}
