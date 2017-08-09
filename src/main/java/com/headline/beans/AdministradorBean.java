package com.headline.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Entrega;
import com.headline.model.Status;
import com.headline.persistence.EntregasDAO;

@Named
@ViewScoped
public class AdministradorBean implements Serializable{
	
	private EntregasDAO dao;
	
	private Status status;
	
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void initialize() {
		dao = new EntregasDAO();
	}
	
	public String loadNewDigitalItem(){
		return "new_digital_item?faces-redirect=true";
	}
	
	public String loadNewPhysicalItem(){
		return "new_physical_item?faces-redirect=true";
	}
	
	public List<Entrega> getEntregas(){
		return dao.getEntregas();
	}

	public Status[] getStatus() {
		return Status.values();
	}
	
	public void atualizarEntrega(Entrega entrega) {
		System.out.println("Chegou aqui");
		System.out.println(entrega.getStatus());
		try {
			entrega.setStatus(status);
			dao.update(entrega);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Entrega atualizada","Entrega atualizada com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Houve um problema ao atualizar a entrega",e.getMessage()));
			e.printStackTrace();
		}
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
