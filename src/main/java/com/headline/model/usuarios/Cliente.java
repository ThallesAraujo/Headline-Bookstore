package com.headline.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.headline.model.Cartao;
import com.headline.model.Compra;

@Entity
@DiscriminatorValue(value="Cliente")
public class Cliente extends Usuario {
	
	@OneToMany
	private List<Cartao> cartoes;
	
	@OneToMany
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
	
	
	
	

}
