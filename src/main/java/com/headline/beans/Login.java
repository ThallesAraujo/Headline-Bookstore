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

import com.headline.model.usuarios.Administrador;
import com.headline.model.usuarios.Usuario;
import com.headline.persistence.PlaceboDatabase;

@ViewScoped
@ManagedBean
public class Login implements Serializable {
	
	private String usuario;
	
	private String senha;
	
	@PostConstruct
	public void createAdmin(){
		Usuario adm = new Administrador();
		adm.setNome("Thalles H. Araújo");
		adm.setEmail("thalles@mail.com");
		adm.setSenha("thalles@adm123");
		ArrayList<Usuario> users = new ArrayList<Usuario>(Arrays.asList(adm));
		PlaceboDatabase.setUsuarios(users);
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
		
		Usuario u = PlaceboDatabase.getUsuario(usuario, senha);
		
		if(u!=null){
			return DashboardLoader.loadDashboard(u);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este usuário não está cadastrado"));
			return null;
		}
	}
	
	
	

}
