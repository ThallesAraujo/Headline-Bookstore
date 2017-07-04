package com.headline.model.usuarios;

import java.util.ArrayList;

import com.headline.model.Cartao;

public class Cliente extends Usuario {
	
	private ArrayList<Cartao> cartoes;

	public Cliente(String nome, String endereco, String email, String senha, String cpf) {
		super(nome, endereco, email, senha, cpf);
		cartoes = new ArrayList<Cartao>();
	}

}
