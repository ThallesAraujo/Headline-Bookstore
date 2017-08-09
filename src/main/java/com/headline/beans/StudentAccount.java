package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.headline.model.usuarios.Estudante;
import com.headline.persistence.GenericDAO;

@Named
@SessionScoped
public class StudentAccount extends UsuarioOperations implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estudante estudante;

	private GenericDAO dao;

	@PostConstruct
	public void initialize() {
		estudante = new Estudante();
		dao = new GenericDAO();
	}

	public String salvarConta() {

		try {
			String senha = criptografarSenha(estudante.getSenha());
			estudante.setSenha(senha);
			dao.save(estudante);
			return estudante.loadDashboard();
		} catch (Exception e) {
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
