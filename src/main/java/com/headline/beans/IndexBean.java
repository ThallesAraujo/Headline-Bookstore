package com.headline.beans;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import org.primefaces.model.UploadedFile;
import org.primefaces.model.UploadedFileWrapper;

import com.headline.model.itens.Item;
import com.headline.persistence.GenericDAO;

import java.nio.file.Files;
import java.nio.file.Path;


@ManagedBean
@ViewScoped
public class IndexBean{
	
	private GenericDAO dao;
	
	
	@PostConstruct
	public void initialize(){
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
