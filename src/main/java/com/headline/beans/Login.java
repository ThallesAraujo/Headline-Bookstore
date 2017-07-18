package com.headline.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.headline.model.itens.Genero;
import com.headline.model.usuarios.Administrador;
import com.headline.model.usuarios.Usuario;
import com.headline.persistence.GenericDAO;
import com.headline.persistence.UsuarioDAO;

@ViewScoped
@ManagedBean
public class Login implements Serializable {
	
	/**
	 * @TODO Implementar logout
	 */
	
	private String usuario;
	
	private String senha;
	
	private GenericDAO dao;
	
	private DashboardLoader loader;
	
	@PostConstruct
	public void createAdmin(){
		Usuario adm = new Administrador();
		adm.setNome("Thalles H. Araújo");
		adm.setEmail("thalles@mail.com");
		adm.setSenha("thalles@adm123");
		adm.setCpf("044.044.044-44");
		try {
			dao = new GenericDAO();
			dao.save(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String load(){
		return "login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logIn(){
		
		if(loader.getUser()!=null){
			return loader.loadDashboard(loader.getUser());
		}
		
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario u;
		try {
			u = userDAO.getByLogin(usuario, senha);
			
			if(u!=null){
				return loader.loadDashboard(u);
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este usuário não está cadastrado"));
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	

}
