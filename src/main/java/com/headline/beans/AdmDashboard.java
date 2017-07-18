package com.headline.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AdmDashboard {
	
	public String loadNewDigitalItem(){
		return "new_digital_item?faces-redirect=true";
	}
	
	public String loadNewPhysicalItem(){
		return "new_physical_item?faces-redirect=true";
	}

}
