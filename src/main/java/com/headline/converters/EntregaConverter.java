package com.headline.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.headline.model.Entrega;
import com.headline.persistence.GenericDAO;

@FacesConverter(forClass=Entrega.class)
public class EntregaConverter implements Converter{
	
	private GenericDAO dao = new GenericDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		try {
			if (value == null || value.trim().isEmpty()) {
				return null;
			}
			String id = value;
			Entrega entrega = new Entrega();
			return  dao.getByID(entrega, Integer.parseInt(id));
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
		Integer id = ((Entrega) value).getId();

		return (id != null) ? id.toString() : null;
	}
	

}
