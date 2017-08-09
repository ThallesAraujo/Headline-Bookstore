package com.headline.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.itens.Categoria;
import com.headline.model.itens.Item;
import com.headline.persistence.ItemDAO;

@Named
@ViewScoped
public class LivrosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ItemDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new ItemDAO();
	}
	
	
	public List<Item> getLivros(){
		try{
			
			List<Item> revistas = dao.getAllItens(Categoria.LIVRO);
			return revistas;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String load(){
		return "livros?faces-redirect=true";
	}

}
