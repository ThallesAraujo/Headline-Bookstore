package com.headline.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class Cadastro implements Serializable{
	
	public String loadInit(){
		return "new_user?faces-redirect=true";
	}
	
	public String loadNewDefaultUser(){
		return "new_default_user?faces-redirect=true";
	}

	public String loadNewStudentUser(){
		return "new_student_account?faces-redirect=true";
	}
	
	public String loadNewRepresentantUser(){
		return "new_representant_account?faces-redirect=true";
	}
	
	public String loadNewProducertUser(){
		return "new_producer_account?faces-redirect=true";
	}
}
