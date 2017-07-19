package com.headline.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.headline.model.itens.Item;
import com.headline.persistence.GenericDAO;

@FacesConverter(forClass = Item.class)
public class ItemConverter implements Converter{

	private GenericDAO dao = new GenericDAO();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		try {
			if (value == null || value.trim().isEmpty()) {
				return null;
			}
			String id = value;
			Item item = new Item();
			return dao.getByID(item, Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value == null) {
			return null;
		}
		Integer id = ((Item) value).getId();

		return (id != null) ? id.toString() : null;
	}
	
	

}
