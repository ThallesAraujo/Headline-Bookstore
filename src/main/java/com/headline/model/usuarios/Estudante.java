package com.headline.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.headline.model.Cartao;
import com.headline.model.Compra;
import com.headline.model.itens.Item;

@Entity
@DiscriminatorValue(value="Estudante")
public class Estudante extends Cliente{
	
	private String instituicao;
	
	
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}	
	

}
