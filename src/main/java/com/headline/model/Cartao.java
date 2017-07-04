package com.headline.model;

import java.time.LocalDate;

import com.headline.model.usuarios.Usuario;


public class Cartao {

	private Usuario usuario;
	private String titular;
	private LocalDate dataVencimento;
	private int numero;
	private short digitosDeSeguranca;

	public Cartao() {
	};

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
