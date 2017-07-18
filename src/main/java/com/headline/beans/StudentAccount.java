package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.headline.model.usuarios.Estudante;
import com.headline.persistence.GenericDAO;

@ManagedBean
@SessionScoped
public class StudentAccount implements Serializable{
	
	private Estudante estudante;
	
	private GenericDAO dao;
	
	private DashboardLoader loader;
	
	private String instituicao;
	
	@PostConstruct
	public void initialize(){
		
		estudante = new Estudante();
		dao = new GenericDAO();
		loader = new DashboardLoader();
		instituicao = new String();
		
	}
	
	
	public String salvarConta(){
		
		try{
			loader.setUser(estudante);
			dao.save(instituicao);
			dao.save(estudante);
			return loader.loadDashboard(estudante);
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		
	}
	
	

	public String getInstituicao() {
		return instituicao;
	}



	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}



	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	

}
