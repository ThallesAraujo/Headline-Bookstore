package com.headline.beans;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.headline.model.usuarios.Estudante;
import com.headline.persistence.GenericDAO;

@ManagedBean
@SessionScoped
public class StudentAccount extends UsuarioOperations implements Serializable{
	
	private Estudante estudante;
	
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize(){
		
		estudante = new Estudante();
		dao = new GenericDAO();
		
	}
	
	
	public String salvarConta(){
		
		try{
			String senha = criptografarSenha(estudante.getSenha());
			estudante.setSenha(senha);
			dao.save(estudante);
			return estudante.loadDashboard();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	

}
