package com.headline.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Entrega;
import com.headline.persistence.ClienteDAO;

@Named
@ViewScoped
public class CustomerDeliversBean extends UsuarioOperations implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new ClienteDAO();
	}
	

	public String load() {
		return "customer_delivers?faces-redirect=true";
	}
	
	public List<Entrega> getEntregas(){
		return dao.getEntregas(getUsuarioLogadoAsCustomer());
	}
}
