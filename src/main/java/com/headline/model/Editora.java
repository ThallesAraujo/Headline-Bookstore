package com.headline.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Editora{
	
	private String nome;
	@Id
	private String cnpj;
	
	private String email;
	
	@OneToMany (mappedBy="editora")
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

	
	
	
	
}
