package com.headline.beans;

import java.io.IOException;
import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.headline.model.usuarios.Cliente;
import com.headline.model.usuarios.Usuario;
import com.headline.persistence.UsuarioDAO;

@ManagedBean
@RequestScoped
public class UsuarioBean extends UsuarioOperations{
	
	public void logout() throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();
		ec.redirect(ec.getApplicationContextPath() + "/index.xhtml?faces-redirect=true");
		
	}
	
	
	public boolean isSomeoneLoggedIn(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal principal = externalContext.getUserPrincipal();
		return principal!=null;
	}
	
	public boolean isCurrentUser(String type){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		return externalContext.isUserInRole(type);
	}
	
	
}
