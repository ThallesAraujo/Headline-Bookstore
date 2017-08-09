package com.headline.beans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


@Named
@RequestScoped
public class UsuarioBean extends UsuarioOperations implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
