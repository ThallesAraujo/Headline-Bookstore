package com.headline.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.headline.model.itens.Categoria;
import com.headline.model.itens.Item;

public class ItemDAO extends GenericDAO {

	public List<Item> getAllItens(Categoria categoria) throws Exception {

		EntityManager em = getEntityManager();
		List<Item> itens = null;

		try {
			TypedQuery<Item> itemQuery = em.createQuery("SELECT i FROM Item i WHERE i.categoria = :categoria",
					Item.class);
			itemQuery.setParameter("categoria", categoria);
			itens = itemQuery.getResultList();
			return itens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Item> searchItems(String searchTerms) {
		EntityManager em = getEntityManager();
		List<Item> itens = null;
		
		try {
			TypedQuery<Item> itemQuery = em.createQuery("SELECT i FROM Item i WHERE i.produtor.nome LIKE :search or i.titulo LIKE :search or i.autor LIKE :search or i.resumo LIKE :search",Item.class);
			itemQuery.setParameter("search", "%" + searchTerms + "%");
			itens = itemQuery.getResultList();
			return itens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
