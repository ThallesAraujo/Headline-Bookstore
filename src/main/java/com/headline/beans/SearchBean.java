package com.headline.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.headline.model.itens.Item;
import com.headline.persistence.ItemDAO;

@ManagedBean
@SessionScoped
public class SearchBean implements Serializable {
	
	private ItemDAO dao;

	private String searchTerms;
	
	
	@PostConstruct
	public void initialize(){
		dao = new ItemDAO();
	}
	
	public String getSearchTerms() {
		return searchTerms;
	}


	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}


	public String search(){
		return "search?faces-redirect=true";
	}
	
	public List<Item> getResultSearch(){
		try{
			return dao.searchItems(searchTerms);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
