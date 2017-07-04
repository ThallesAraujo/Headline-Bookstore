package com.headline.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Usuario;


public class Compra {

	private Usuario usuario;
	private String id;
	private LocalDate data;
	private ArrayList<Item> itens;

	public Compra(Usuario usuario, String id, LocalDate data, ArrayList<Item> itens) {
		super();
		this.usuario = usuario;
		this.id = id;
		this.data = data;
		this.setItens(itens);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

}
