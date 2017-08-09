package com.headline.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.headline.model.itens.Categoria;
import com.headline.model.itens.Digital;
import com.headline.model.itens.Genero;
import com.headline.persistence.GenericDAO;

@Named
@ViewScoped
public class ItemDigitalBean extends UsuarioOperations implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private GenericDAO dao;
	
	private Digital item;
	
	private UploadedFile capa;

	@PostConstruct
	public void initialize() {
		dao = new GenericDAO();
		item = new Digital();
	}

	public Digital getItem() {
		return item;
	}

	public void setItem(Digital item) {
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
			if (item.getArquivo() != null) {
				try{
					if(!getUsuarioLogadoAsProducer().isFuncionarioEditora()) {
						item.setAutor(getUsuarioLogado().getNome());
					}
					item.setProdutor(getUsuarioLogadoAsProducer().getEditora());
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
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O arquivo não foi selecionado",
						"Selecione o arquivo que representa o item."));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("A capa não foi selecionada", "Selecione a imagem de capa do item."));
		}
		return "";
	}
	public Genero[] getGeneros() {
		return Genero.values();
	}
	

	public UploadedFile getCapa() {
		return capa;
	}

	public void setCapa(UploadedFile capa) {
		this.capa = capa;
	}


	public Categoria[] getCategorias() {
		return Categoria.values();
	}
}
