package com.headline.model.usuarios;

import com.headline.model.Produtor;

public class Escritor extends Produtor{

	private String senha;
	
	/**
	 * Conta para escritores independentes (necessário possuir CNPJ)
	 * @param nome
	 * @param endereco
	 * @param email
	 * @param cnpj
	 */
	public Escritor(String nome, String endereco, String email, String cnpj, String senha) {
		super(nome, endereco, email, cnpj);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
