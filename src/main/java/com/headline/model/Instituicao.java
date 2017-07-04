package com.headline.model;

import java.util.ArrayList;

import com.headline.model.usuarios.Estudante;
import com.headline.model.usuarios.Representante;

public class Instituicao {

	// neste caso, o ID da instituição é a sigla da mesma
	private String id, nome;
	private Categoria categoria;
	private ArrayList<Bibliografia> bibliografias;
	private ArrayList<Representante> representantes;
	private ArrayList<Estudante> estudantes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public enum Categoria {
		UNIVERSIDADE, FACULDADE, INSTITUTO_FEDERAL, ESCOLA;
	}

	public ArrayList<Bibliografia> getBibliografias() {
		return bibliografias;
	}

	public void setBibliografias(ArrayList<Bibliografia> bibliografias) {
		this.bibliografias = bibliografias;
	}

	public ArrayList<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(ArrayList<Representante> representantes) {
		this.representantes = representantes;
	}

	public ArrayList<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(ArrayList<Estudante> estudantes) {
		this.estudantes = estudantes;
	}

}
