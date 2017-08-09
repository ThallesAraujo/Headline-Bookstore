package com.headline.model.itens;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Item_Digital")
public class Digital extends Item implements Serializable{

	private String arquivo;
	
	public Digital(){}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	

	

}
