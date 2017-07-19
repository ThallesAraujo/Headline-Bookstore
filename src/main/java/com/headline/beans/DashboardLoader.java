package com.headline.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.headline.model.itens.Item;
import com.headline.model.usuarios.Usuario;

@ManagedBean
@ApplicationScoped
public class DashboardLoader implements Serializable{
	

	private static Usuario user;
	
	private static ArrayList<Item> carrinho = new ArrayList<Item>();
	
	public static String loadDashboard(Usuario u) {
		user = u;
		if(u.getClass().getSimpleName().equals("Administrador")){
			return "administrative_dashboard?faces-redirect=true";
		}else if(u.getClass().getSimpleName().equals("Cliente")){
			return "customer_dashboard?faces-redirect=true";
		}else{
			return null;
		}
	}

	public static ArrayList<Item> getCarrinho() {
		return carrinho;
	}



	public static void setCarrinho(ArrayList<Item> carrinho) {
		DashboardLoader.carrinho = carrinho;
	}



	public static Usuario getUser() {
		return user;
	}
	
	public static String logOut(){
		user = null;
		return "index?faces-redirect=true";
	}

	public static void setUser(Usuario user) {
		DashboardLoader.user = user;
	}
	
	

}
