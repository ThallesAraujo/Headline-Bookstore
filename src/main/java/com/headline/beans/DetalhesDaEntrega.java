package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Entrega;
import com.headline.model.Status;
import com.headline.persistence.GenericDAO;

@Named
@ViewScoped
public class DetalhesDaEntrega implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Entrega ent;
	
	private Status status;
	
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new GenericDAO();
		status = Status.PENDENTE;
	}
	
	public String load() {
		return "deliver_details?faces-redirect=true";
	}
	
	public void mudarStatus() {
		
		System.out.println(ent.getCompra().getCliente().getNome());
		
		try {
			ent.setStatus(status);
			dao.update(ent);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado alterado", "O estado da entrega foi alterado"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na operaçaõ", e.getMessage()));// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Entrega getEnt() {
		return this.ent;
	}
	
	public void setEnt(Entrega entrega) {
		this.ent = entrega;
	}
	
	public Status[] getStates() {
		return Status.values();
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	
	
	

}
