package com.headline.model.itens;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.headline.model.Editora;

@Entity
@DiscriminatorValue(value="Item_Digital")
public class Digital extends Item implements Serializable{

	@Lob
	private byte[] arquivo;
	
	public Digital(){}
	
	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	

}
