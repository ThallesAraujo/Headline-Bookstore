package com.headline.model;

public abstract class Produtor {
	
	private String nome;
	private String endereco;
	private String email;
	private String cnpj;
	
	
	public Produtor(String nome, String endereco, String email, String cnpj) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.cnpj = cnpj;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
	

}
