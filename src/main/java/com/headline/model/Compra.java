package com.headline.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Usuario;

@Entity
public class Compra {
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Usuario usuario;
	
	@Id
	private String id;
	
	private LocalDate data;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "fk_compra"), inverseJoinColumns = @JoinColumn(name = "fk_cliente"))
	private List<Item> itens;
	
	public Compra(){}

	public Compra(Usuario usuario, LocalDate data, ArrayList<Item> itens) {
		super();
		this.usuario = usuario;
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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
