package com.headline.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class ProdutorBean {
	
	private boolean funcionarioEditora = false;;

	public boolean isFuncionarioEditora() {
		return funcionarioEditora;
	}

	public void setFuncionarioEditora(boolean funcionarioEditora) {
		this.funcionarioEditora = funcionarioEditora;
	}
	
	
	
	
	
	

}
