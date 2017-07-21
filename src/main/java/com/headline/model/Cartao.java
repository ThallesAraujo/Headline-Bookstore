package com.headline.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.headline.model.usuarios.Usuario;

@Entity
public class Cartao implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Usuario usuario;
	
	private String titular;
	private Date dataVencimento;
	
	@Id
	private BigInteger numero;
	private short digitosDeSeguranca;

	public Cartao() {};

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigInteger getNumero() {
		return this.numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}

	public short getDigitosDeSeguranca() {
		return this.digitosDeSeguranca;
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
