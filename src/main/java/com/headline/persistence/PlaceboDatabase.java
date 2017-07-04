package com.headline.persistence;

import java.util.ArrayList;

import com.headline.model.usuarios.Usuario;

public class PlaceboDatabase {
	
	private static ArrayList<Usuario> usuarios;

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> users) {
		usuarios = users;
	}
	
	public static Usuario getUsuario(String email, String senha){
		for(Usuario u: usuarios){
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
				return u;
			}
		}
		return null;
	}

}
