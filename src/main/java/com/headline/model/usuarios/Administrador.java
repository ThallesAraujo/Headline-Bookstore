package com.headline.model.usuarios;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.headline.model.Produtor;

@Entity
@DiscriminatorValue(value="Administrador")
public class Administrador extends Produtor implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String loadDashboard() {
		return "administrative_dashboard?faces-redirect=true";
	}
	
	
	

}
