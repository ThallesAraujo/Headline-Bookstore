package com.headline.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.headline.model.usuarios.Usuario;

public class UsuarioDAO extends GenericDAO {
	
	public Usuario getByLogin(String usuario, String senha) throws Exception {
		EntityManager em = getEntityManager();
		Usuario resultado = null;
		try {
			TypedQuery<Usuario> usuarioQuery = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
			usuarioQuery.setParameter("email", usuario);
			resultado = usuarioQuery.getSingleResult();
			if(resultado.getSenha().equals(senha)){
				return resultado;
			}else{
				throw new Exception("Senha incorreta.");
			}
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new Exception("Erro na recuperação do item.", pe);
		} finally {
			em.close();
		}
	}
	
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
		
	}
	
	
	


