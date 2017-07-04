package com.headline.model.itens;

import com.headline.model.Editora;

public class Digital extends Item {

	private String link;

	public Digital(String id, String titulo, String autor, Tipo tipo, Categoria categoria, Editora editora) {
		super(id, titulo, autor, tipo, categoria, editora);
		// TODO Auto-generated constructor stub
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
