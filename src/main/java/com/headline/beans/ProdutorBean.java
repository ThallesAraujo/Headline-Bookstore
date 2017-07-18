package com.headline.beans;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.headline.model.Editora;
import com.headline.model.Produtor;
import com.headline.persistence.GenericDAO;

@ViewScoped
@ManagedBean
public class ProdutorBean {
	
	private boolean funcionarioEditora = false;
	
	private Produtor produtor;
	private Editora editora;
	private GenericDAO dao;
	
	@PostConstruct
	public void initialize(){
		produtor = new Produtor();
		editora = new Editora();
		dao = new GenericDAO();
	}

	
	
	public boolean isFuncionarioEditora() {
		return funcionarioEditora;
	}



	public void setFuncionarioEditora(boolean funcionarioEditora) {
		this.funcionarioEditora = funcionarioEditora;
	}



	public Produtor getProdutor() {
		return produtor;
	}



	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}



	public Editora getEditora() {
		return editora;
	}



	public void setEditora(Editora editora) {
		this.editora = editora;
	}



	public GenericDAO getDao() {
		return dao;
	}



	public void setDao(GenericDAO dao) {
		this.dao = dao;
	}



	public String salvarProdutor(){
		if(funcionarioEditora){
			try{
				produtor.setEditora(editora);
				editora.setFuncionarios(Arrays.asList(produtor));
				dao.save(editora);
				dao.save(produtor);
				return DashboardLoader.loadDashboard(produtor);
			}catch(Exception e){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				return null;
			}
		}else{
			try{
				editora.setNome("Escritor Independente");
				editora.setEmail(produtor.getEmail());
				editora.setCnpj(produtor.getCpf());
				produtor.setEditora(editora);
				editora.setFuncionarios(Arrays.asList(produtor));
				dao.save(editora);
				dao.save(produtor);
				return DashboardLoader.loadDashboard(produtor);
			}catch(Exception e){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				return null;
			}
		}
	}
	
	
	
	
	
	

}
