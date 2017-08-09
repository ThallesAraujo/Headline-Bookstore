package com.headline.persistence;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.headline.model.Editora;
import com.headline.model.Produtor;
import com.headline.model.usuarios.Usuario;

public class UsuarioDAO extends GenericDAO implements Serializable{
	
	
	public Usuario getByLogin(String usuario) throws Exception{
		
		EntityManager em = getEntityManager();
		Usuario resultado = null;
		try {
			TypedQuery<Usuario> usuarioQuery = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
			usuarioQuery.setParameter("email", usuario);
			resultado = usuarioQuery.getSingleResult();
			return resultado;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new Exception("Erro na recuperação do item.", pe);
		} finally {
			em.close();
		}
	}
	
	public void saveWithExistingEditora(Editora editora, Produtor produtor) throws Exception {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try{
			editora = (Editora) getByID(editora, editora.getCnpj());
			editora.getFuncionarios().add(produtor);
			produtor.setEditora(editora);
			em.merge(editora);
			transaction.commit();
		} catch (PersistenceException pe) {
			transaction.rollback();
			pe.printStackTrace();
			throw new Exception("Erro na exclusão", pe);
		} finally {
			em.close();
		}
	}
	
	
		
	}
	
	
	


