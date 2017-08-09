package com.headline.model.itens;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Item_Físico")
public class Fisico extends Item implements Serializable{
	
	private int quantidadeEmEstoque;
	
	public Fisico(){}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	public boolean isEmFalta(){
		return quantidadeEmEstoque == 0;
	}

	
}
