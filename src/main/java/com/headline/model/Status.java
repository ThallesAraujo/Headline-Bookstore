package com.headline.model;

public enum Status {
	
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
