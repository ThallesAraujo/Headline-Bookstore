package com.headline.model;

import java.io.Serializable;

public enum Status implements Serializable{
	
	PENDENTE("Pendente"),
	EM_TRANSPORTE("Em Transporte"),
	ENTREGUE("Entregue");
	
	private final String situacao;
	
	private Status(String situacao){
		this.situacao = situacao;
	}
	
	public String getStatus(){
		return this.situacao;
	}

}
