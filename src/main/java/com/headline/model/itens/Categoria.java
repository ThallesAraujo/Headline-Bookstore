package com.headline.model.itens;

public enum Categoria {
	REVISTA("Revista"),PERIODICO("Periódico"),LIVRO("Livro");
	
	private final String descricao;
	
	private Categoria(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
