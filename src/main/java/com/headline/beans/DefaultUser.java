package com.headline.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.headline.model.usuarios.Cliente;
import com.headline.persistence.GenericDAO;

@ManagedBean
@ViewScoped
public class DefaultUser extends UsuarioOperations {

	private Cliente cliente;
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize(){
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
