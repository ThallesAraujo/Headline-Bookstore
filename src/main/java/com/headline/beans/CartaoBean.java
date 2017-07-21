package com.headline.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.headline.model.Cartao;
import com.headline.persistence.GenericDAO;

@ManagedBean
@ViewScoped
public class CartaoBean extends UsuarioOperations implements Serializable{

	private Cartao cartao;
	
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize(){
		cartao = new Cartao();
		cartao.setNumero(BigInteger.ZERO);
		dao = new GenericDAO();
	}
	
	
	public String salvarCartao(){
		
		try{
			
			cartao.setUsuario(getUsuarioLogadoAsCustomer());
			if(getUsuarioLogadoAsCustomer().getCartoes()!=null){
				getUsuarioLogadoAsCustomer().getCartoes().add(cartao);
			}else{
				getUsuarioLogadoAsCustomer().setCartoes(Arrays.asList(cartao));
			}
			
			dao.update(getUsuarioLogadoAsCustomer());
			dao.save(cartao);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cartão salvo", "Cartão salvo com sucesso"));
			return "index?faces-redirect=true";
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	
	public String load(){
		return "new_payment_method?faces-redirect=true";
	}
	
	
	
	
}
