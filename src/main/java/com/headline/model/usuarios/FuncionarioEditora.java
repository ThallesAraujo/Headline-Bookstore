package com.headline.model.usuarios;

import com.headline.model.Editora;

public class FuncionarioEditora extends Usuario{

	private Editora editora;
	
	private String cargo;
	
	public FuncionarioEditora(String nome, String endereco, String email, String senha, String cpf, Editora editora, String cargo) {
		super(nome, endereco, email, senha, cpf);
		this.editora = editora;
		this.cargo = cargo;
	}
	
	public Editora getEditora(){
		return this.editora;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}


