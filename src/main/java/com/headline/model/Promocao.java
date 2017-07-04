package com.headline.model;

import java.time.LocalDate;

import com.headline.model.usuarios.Usuario;



public class Promocao {

	private Usuario usuario;
	private String id;
	private LocalDate validade;
	private Tipo tipo;

	public Promocao(Usuario usuario, String id, LocalDate validade, Tipo tipo) {
		super();
		this.setUsuario(usuario);
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public enum Tipo {
		FRETE, DESCONTO;
	}

}
