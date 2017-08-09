package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.usuarios.Cliente;
import com.headline.persistence.GenericDAO;

@Named
@ViewScoped
public class DefaultUser extends UsuarioOperations implements Serializable{

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize() {
		cliente = new Cliente();
		dao = new GenericDAO();
	}
	
	
	public String salvarCliente(){
		try{
			String senha = criptografarSenha(cliente.getSenha());
			cliente.setSenha(senha);
			dao.save(cliente);
			return cliente.loadDashboard();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
