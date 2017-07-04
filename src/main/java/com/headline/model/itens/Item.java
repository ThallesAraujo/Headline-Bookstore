package com.headline.model.itens;

import com.headline.model.Editora;

public abstract class Item {

	private String id, titulo, autor;
	private Tipo tipo;
	private Categoria categoria;
	private Editora editora;
	
	public Item(String id, String titulo, String autor, Tipo tipo, Categoria categoria, Editora editora) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.tipo = tipo;
		this.categoria = categoria;
		this.editora = editora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	

}
