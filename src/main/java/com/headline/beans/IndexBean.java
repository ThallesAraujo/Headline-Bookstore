package com.headline.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.itens.Item;
import com.headline.persistence.GenericDAO;


@Named
@ViewScoped
public class IndexBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize() {
		dao = new GenericDAO();
	}
	

	public GenericDAO getDao() {
		return dao;
	}


	public String getImageContent(byte[] imageContent) {
		
		return Base64.getEncoder().encodeToString(imageContent);
		
	    
	}


	public List<Item> getCatalogo(){
		try{
			
			List<Item> itens = new ArrayList<Item>();
			Item item = new Item();
			for(Object o: dao.getAll(item)){
				itens.add((Item) o);
			}
			
			return itens;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
