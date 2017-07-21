package com.headline.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.headline.model.Cartao;
import com.headline.model.Compra;
import com.headline.model.itens.Item;

@Entity
@DiscriminatorValue(value="Cliente")
public class Cliente extends Usuario{
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT) 
	private List<Cartao> cartoes;
	
	@OneToOne (targetEntity = Item.class)
	private List<Item> carrinho;
	
	@OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Compra> compras;
	
	
	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Item> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Item> carrinho) {
		this.carrinho = carrinho;
	}

	@Override
	public String loadDashboard() {
		return "customer_dashboard?faces-redirect=true";
	}
	
	
	
	
	
	

}
