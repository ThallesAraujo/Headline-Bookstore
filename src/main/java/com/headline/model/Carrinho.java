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

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;

@Entity
public class Carrinho implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Item> itens;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="carrinho")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
