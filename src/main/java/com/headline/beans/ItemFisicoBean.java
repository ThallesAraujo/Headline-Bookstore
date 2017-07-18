package com.headline.beans;

//
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.headline.model.itens.Categoria;
import com.headline.model.itens.Digital;
import com.headline.model.itens.Fisico;
import com.headline.model.itens.Genero;
import com.headline.persistence.GenericDAO;
import com.headline.utils.ToolsProduct;

@ManagedBean
@ViewScoped
public class ItemFisicoBean implements Serializable {

	private Fisico item;
	
	private GenericDAO dao;
	
	private UploadedFile capa;

	@PostConstruct
	public void instantiate() {
		dao = new GenericDAO();
		item = new Fisico();
	}

	public Fisico getItem() {
		return item;
	}

	public void setItem(Fisico item) {
		this.item = item;
	}


	public void uploadCapa(FileUploadEvent event) {

		if (event.getFile().getFileName().endsWith(".png") || event.getFile().getFileName().endsWith("jpg")
				|| event.getFile().getFileName().endsWith("jpeg")) {
			capa = event.getFile();
			item.setCapa(capa.getContents());
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("O formato de imagem não é suportado."));
		}

	}

	public String salvarItem() {

		if (item.getCapa() != null) {
				try{
					dao.save(item);
				}catch(Exception  e){
					e.printStackTrace();
				}
				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.setKeepMessages(true);
				flash.setRedirect(true);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Item salvo", item.getTitulo() + " salvo com sucesso"));
				return "index?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A capa não foi selecionada", "Selecione a imagem de capa do item."));
		}
		return "";
	}


	public Genero[] getGeneros() {
		return Genero.values();
	}

	public Categoria[] getCategorias() {
		return Categoria.values();
	}

	public UploadedFile getCapa() {
		return capa;
	}

	public void setCapa(UploadedFile capa) {
		this.capa = capa;
	}
	
	
}