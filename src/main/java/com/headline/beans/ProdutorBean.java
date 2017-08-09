package com.headline.beans;

import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Editora;
import com.headline.model.Produtor;
import com.headline.persistence.GenericDAO;
import com.headline.persistence.UsuarioDAO;

@Named
@ViewScoped
public class ProdutorBean extends UsuarioOperations implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean funcionarioEditora = false;

	
	private Produtor produtor;

	
	private Editora editora;

	
	private UsuarioDAO dao;

	@PostConstruct
	public void initialize() {
		produtor = new Produtor();
		editora = new Editora();
		dao = new UsuarioDAO();
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

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	public String salvarProdutor() throws Exception {
		String senha = criptografarSenha(produtor.getSenha());
		produtor.setSenha(senha);
		produtor.setFuncionarioEditora(funcionarioEditora);
		if (funcionarioEditora) {
			try {
				if (dao.getByID(editora, editora.getCnpj()) != null) {
					dao.saveWithExistingEditora(editora, produtor);
				} else {
					produtor.setEditora(editora);
					editora.setFuncionarios(Arrays.asList(produtor));
					editora.setEmail(produtor.getEmail());
					dao.save(editora);
				}

				return produtor.loadDashboard();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			}
		} else {
			try {
				editora.setNome("Escritor Independente");
				editora.setEmail(produtor.getEmail());
				editora.setCnpj(produtor.getCpf());
				produtor.setEditora(editora);
				editora.setFuncionarios(Arrays.asList(produtor));
				dao.save(editora);
				return produtor.loadDashboard();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			}
		}

		return null;
	}

}
