package com.headline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.headline.model.usuarios.Usuario;

@Entity
public class Cartao {
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Usuario usuario;
	
	private String titular;
	private LocalDate dataVencimento;
	@Id
	private Integer numero;
	private short digitosDeSeguranca;

	public Cartao() {};

	public Cartao(String titular, LocalDate dataVencimento, int numero, short digitosDeSeguranca, Usuario usuario) {
		super();
		this.titular = titular;
		this.dataVencimento = dataVencimento;
		this.numero = numero;
		this.digitosDeSeguranca = digitosDeSeguranca;
		this.setUsuario(usuario);
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public short getDigitosDeSeguranca() {
		return digitosDeSeguranca;
	}

	public void setDigitosDeSeguranca(short digitosDeSeguranca) {
		this.digitosDeSeguranca = digitosDeSeguranca;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
