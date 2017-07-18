package com.headline.model.itens;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.headline.model.Editora;

@Entity
@DiscriminatorValue(value="Item_Físico")
public class Fisico extends Item {
	
	private int quantidadeEmEstoque;
	
	public Fisico(){}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	
}
