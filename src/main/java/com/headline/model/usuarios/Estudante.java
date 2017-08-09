package com.headline.model.usuarios;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value="Estudante")
public class Estudante extends Cliente implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	private String instituicao;
	
	
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}	
	

}
