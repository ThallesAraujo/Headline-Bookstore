package com.headline.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.headline.model.Cartao;
import com.headline.model.Compra;

@Entity
@DiscriminatorValue(value="Estudante")
public class Estudante extends Usuario {
	
	private String instituicao;
	
	@OneToMany
	private List<Cartao> cartoes;
	
	private String matricula;

	@OneToMany
	private List<Compra> compras;

	
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	
	
	

}
