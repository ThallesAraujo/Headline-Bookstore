package com.headline.model;

import java.util.ArrayList;

import com.headline.model.usuarios.FuncionarioEditora;

public abstract class Editora extends Produtor{
	
	private ArrayList<FuncionarioEditora> funcionarios;
	private ArrayList<FuncionarioEditora> admnistradores;

	public Editora(String nome, String endereco, String email, String cnpj) {
		super(nome, endereco, email,cnpj);
		
	}

	public ArrayList<FuncionarioEditora> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<FuncionarioEditora> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<FuncionarioEditora> getAdmnistradores() {
		return admnistradores;
	}

	public void setAdmnistradores(ArrayList<FuncionarioEditora> admnistradores) {
		this.admnistradores = admnistradores;
	}
	
	
	
	
}
