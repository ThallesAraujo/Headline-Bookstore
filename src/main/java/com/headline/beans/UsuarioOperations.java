package com.headline.beans;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.headline.model.Produtor;
import com.headline.model.usuarios.Cliente;
import com.headline.model.usuarios.Usuario;
import com.headline.persistence.UsuarioDAO;

public abstract class UsuarioOperations {
	
	private static UsuarioDAO dao;
	
	
	
	protected static String criptografarSenha(String password) throws Exception {
		dao = new UsuarioDAO();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String output = bigInt.toString(16);
			return output;
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Não foi possível criptografar a senha!");
		} catch (UnsupportedEncodingException e) {
			throw new Exception("Não foi possível criptografar a senha!");
		}
	}
	
	public Usuario getUsuarioLogado(){
		dao = new UsuarioDAO();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal principal = externalContext.getUserPrincipal();
		Usuario logado = null;
		if (principal != null) {
			try{
				logado = dao.getByLogin(principal.getName());
				return logado;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return logado;
	}
	
	public Cliente getUsuarioLogadoAsCustomer(){
		dao = new UsuarioDAO();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal principal = externalContext.getUserPrincipal();
		Cliente logado = null;
		if (principal != null) {
			try{
				logado = (Cliente) dao.getByLogin(principal.getName());
				return logado;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return logado;
	}
	
	public Produtor getUsuarioLogadoAsProducer(){
		dao = new UsuarioDAO();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal principal = externalContext.getUserPrincipal();
		Produtor logado = null;
		if (principal != null) {
			try{
				logado = (Produtor) dao.getByLogin(principal.getName());
				return logado;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return logado;
	}
	

}
