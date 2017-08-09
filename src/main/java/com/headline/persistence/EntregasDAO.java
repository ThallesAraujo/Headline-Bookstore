package com.headline.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.headline.model.Entrega;

public class EntregasDAO extends GenericDAO{
	
	private static final long serialVersionUID = 1L;
	
	
	public List<Entrega> getEntregas(){
		EntityManager em = getEntityManager();
		List<Entrega> entregas = null;
		
		try {
			TypedQuery<Entrega> entregasQuery = em.createQuery("SELECT e FROM Entrega e",Entrega.class);
			entregas = entregasQuery.getResultList();
			return entregas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
