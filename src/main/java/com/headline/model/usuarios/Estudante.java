package com.headline.model.usuarios;

import com.headline.model.Instituicao;

public class Estudante extends Usuario {
	
	private Instituicao instituicao;
	
	private String matricula;

	public Estudante(String nome, String endereco, String email, String senha, Instituicao instituicao,String cpf, String matricula) {
		super(nome, endereco, email, senha,cpf);
		this.instituicao = instituicao;
		this.matricula = matricula;
		
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	

}
