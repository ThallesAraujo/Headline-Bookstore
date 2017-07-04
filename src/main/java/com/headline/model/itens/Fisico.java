package com.headline.model.itens;

import com.headline.model.Editora;

public class Fisico extends Item {
	
	private String isbn;
	private int quantidadeEmEstoque;

	public Fisico(String id, String titulo, String autor, Tipo tipo, Categoria categoria, int quantidade, Editora editora) {
		super(id, titulo, autor, tipo, categoria, editora);
		this.quantidadeEmEstoque = quantidade;
		// TODO Auto-generated constructor stub
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	
}
