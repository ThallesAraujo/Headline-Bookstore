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
public class PeriodicosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private ItemDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new ItemDAO();
	}

	
	public List<Item> getPeriodicos(){
		try{
			
			List<Item> revistas = dao.getAllItens(Categoria.PERIODICO);
			return revistas;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String load(){
		return "periodicos?faces-redirect=true";
	}

}
