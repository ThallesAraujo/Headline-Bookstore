package com.headline.model.usuarios;

public abstract class Usuario {
	
	private String nome,endereco,email,senha,cpf;
	
	public Usuario(){};

	public Usuario(String nome, String endereco, String email, String senha, String cpf) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}
