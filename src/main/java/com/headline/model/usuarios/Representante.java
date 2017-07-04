package com.headline.model.usuarios;

import com.headline.model.Instituicao;

public class Representante extends Usuario {
	
	private Instituicao instituicao;

	public Representante(String nome, String endereco, String email, String senha, Instituicao instituicao, String cpf) {
		super(nome, endereco, email, senha,cpf);
		this.setInstituicao(instituicao);
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
