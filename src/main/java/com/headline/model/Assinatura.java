package com.headline.model;

import java.time.LocalDate;
import com.headline.model.usuarios.Usuario;

public class Assinatura {

	private Usuario usuario;
	private String id;
	private LocalDate validade;
	private Status status;

	public Assinatura() {
	}

	public Assinatura(String id, LocalDate validade, Usuario usuario) {
		super();
		this.id = id;
		this.validade = validade;
		this.setUsuario(usuario);
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public enum Status {
		REGULAR, CANCELADA, CANCELADAPORFALTADEPAGAMENTO, VENCIDA;
	}

}
