package com.headline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Editora implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@Id
	private String cnpj;
	
	private String email;
	
	@OneToMany (mappedBy="editora", fetch= FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Produtor> funcionarios;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	private String logradouro;

	public Editora(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produtor> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Produtor> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Editora other = (Editora) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	

	
	
	
	
}
