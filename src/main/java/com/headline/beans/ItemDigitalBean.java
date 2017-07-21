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

import com.headline.model.Editora;
import com.headline.model.itens.Categoria;
import com.headline.model.itens.Digital;
import com.headline.model.itens.Genero;
import com.headline.persistence.GenericDAO;

@ManagedBean
@ViewScoped
public class ItemDigitalBean extends UsuarioOperations implements Serializable {

	private GenericDAO dao;
	
	private Digital item;
	
	private Editora headline;
	
	private UploadedFile capa;
	
	private UploadedFile arquivo;

	@PostConstruct
	public void instantiate() {
		dao = new GenericDAO();
		item = new Digital();
		headline = new Editora();
		headline.setNome("Headline Publications");
		headline.setCnpj("999.999.999-99");
		headline.setEmail("contact@headline.com");
		try{
			dao.save(headline);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Digital getItem() {
		return item;
	}

	public void setItem(Digital item) {
		this.item = item;
	}

	public void uploadArquivo(FileUploadEvent event) {

		if (event.getFile().getFileName().endsWith("pdf") || event.getFile().getFileName().endsWith("epub")) {
			arquivo = event.getFile();
			item.setArquivo(arquivo.getContents());
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("O formato de arquivo não é suportado."));
		}

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
					item.setAutor(getUsuarioLogado().getNome());
					item.setProdutor(headline);
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

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public Categoria[] getCategorias() {
		return Categoria.values();
	}
}
