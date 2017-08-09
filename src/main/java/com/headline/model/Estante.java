package com.headline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;

@Entity
public class Estante implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(mappedBy="estante")
	private Cliente cliente;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Item> livros;

	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getLivros() {
		return livros;
	}

	public void setLivros(List<Item> livros) {
		this.livros = livros;
	}
	
	

}
