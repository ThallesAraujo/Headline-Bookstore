package com.headline.model;

import java.util.ArrayList;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Representante;

public class Bibliografia {

	private Representante representante;
	private String id, turma;
	private ArrayList<Item> itens;

	public Bibliografia() {
	}

	public Bibliografia(Representante representante, String id, String turma, ArrayList<Item> itens) {
		super();
		this.representante = representante;
		this.id = id;
		this.turma = turma;
		this.itens = itens;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	// Tip: Usar modus operandi do JavaFX
	// (getItens().addAll())

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

}
