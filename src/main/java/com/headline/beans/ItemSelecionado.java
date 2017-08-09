package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.itens.Item;
import com.headline.persistence.ClienteDAO;

@Named
@ViewScoped
public class ItemSelecionado extends UsuarioOperations implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new ClienteDAO();
	}
	
	private Item it;

	public Item getIt() {
		return it;
	}

	public void setIt(Item item) {
		this.it = item;
	}
	
	public String load(){
		return"select_item?faces-redirect=true";
	}
	
	public void adicionarAoCarrinho(Item item) throws Exception {
		dao.adicionarItemAoCarrinho(getUsuarioLogadoAsCustomer(), item);
	}
	
	
	

}
