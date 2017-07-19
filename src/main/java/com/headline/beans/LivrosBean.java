package com.headline.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.headline.model.itens.Categoria;
import com.headline.model.itens.Item;
import com.headline.persistence.ItemDAO;

@ManagedBean
@ViewScoped
public class LivrosBean {
	
	private ItemDAO dao;
	
	@PostConstruct
	public void initialize(){
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
