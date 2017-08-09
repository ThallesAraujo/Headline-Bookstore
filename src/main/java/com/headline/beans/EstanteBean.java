package com.headline.beans;

import java.io.Serializable;
import java.util.Base64;

import javax.faces.view.ViewScoped;
import javax.inject.Named;  

@Named
@ViewScoped
public class EstanteBean extends UsuarioOperations implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public String getImageContent(byte[] imageContent) {

		return Base64.getEncoder().encodeToString(imageContent);

	}
	public String load() {
		return "customer_shelf?faces-redirect=true";
	}
}
