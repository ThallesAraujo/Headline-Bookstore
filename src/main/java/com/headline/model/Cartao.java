package com.headline.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.headline.model.usuarios.Usuario;

@Entity
public class Cartao implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + digitosDeSeguranca;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (digitosDeSeguranca != other.digitosDeSeguranca)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}

}