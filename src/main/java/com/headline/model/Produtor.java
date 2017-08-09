package com.headline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Usuario;

@Entity
@DiscriminatorValue(value="Produtor")
public class Produtor extends Usuario implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT) 
	@JoinColumn(name="fk_produtor")
	private List<Promocao> promocoes;
	
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT) 
	private List<Item> itens;
	
	private boolean funcionarioEditora;
	
	@ManyToOne
	@JoinColumn(name="fk_editora")
	private Editora editora;
	
	private String cargo;
	
	public Produtor(){}

	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

	public boolean isFuncionarioEditora() {
		return funcionarioEditora;
	}

	public void setFuncionarioEditora(boolean funcionarioEditora) {
		this.funcionarioEditora = funcionarioEditora;
	}

	@Override
	public String loadDashboard() {
		return "producer_dashboard?faces-redirect=true";
	}

	
	
	
	

}
