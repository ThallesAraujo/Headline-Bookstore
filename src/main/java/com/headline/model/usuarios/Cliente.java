package com.headline.model.usuarios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.headline.model.Carrinho;
import com.headline.model.Cartao;
import com.headline.model.Compra;
import com.headline.model.Estante;

@Entity
@DiscriminatorValue(value="Cliente")
public class Cliente extends Usuario implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="usuario", orphanRemoval=true)
	@Fetch(FetchMode.SUBSELECT) 
	private List<Cartao> cartoes;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Carrinho carrinho;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Estante estante;
	
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

	@Override
	public String loadDashboard() {
		return "customer_dashboard?faces-redirect=true";
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	
	
	

}