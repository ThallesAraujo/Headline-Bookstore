package com.headline.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;
import com.headline.model.usuarios.Usuario;

@Entity
public class Compra implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cartao cartao;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private LocalDate data;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	private List<Item> itens;


	public Compra() {
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
