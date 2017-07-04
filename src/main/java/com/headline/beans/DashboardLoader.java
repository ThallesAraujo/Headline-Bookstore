package com.headline.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.headline.model.usuarios.Usuario;


@ManagedBean
@ApplicationScoped
public class DashboardLoader {

	private static Usuario user;
	
	public static String loadDashboard(Usuario u) {
		user = u;
		if(u.getClass().getSimpleName().equals("Administrador")){
			return "administrative_dashboard?faces-redirect=true";
		}else{
			return null;
		}
	}

	public static Usuario getUser() {
		return user;
	}

	public static void setUser(Usuario user) {
		DashboardLoader.user = user;
	}
	
	

}
