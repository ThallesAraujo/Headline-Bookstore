package com.headline.converters;

import java.math.BigInteger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.headline.model.Cartao;
import com.headline.persistence.GenericDAO;

@FacesConverter(forClass=Cartao.class)
public class CartaoConverter implements Converter{
	
	private GenericDAO dao = new GenericDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		
		try {
			if (value == null || value.trim().isEmpty()) {
				return null;
			}
			String id = value;
			Cartao cartao = new Cartao();
			return dao.getByID(cartao, BigInteger.valueOf(Long.valueOf(id)));
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
		BigInteger id = ((Cartao) value).getNumero();

		return (id != null) ? id.toString() : null;
	}
	
	

}
