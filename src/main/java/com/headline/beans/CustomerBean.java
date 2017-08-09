package com.headline.beans;

import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Carrinho;
import com.headline.model.Cartao;
import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;
import com.headline.persistence.ClienteDAO;

@Named
@ViewScoped
public class CustomerBean extends UsuarioOperations implements Serializable {

	private static final long serialVersionUID = 1L;


	private Cartao cartao;

	
	private ClienteDAO dao;
	
	@PostConstruct
	public void initialize() {
		cartao = new Cartao();
		dao = new ClienteDAO();
	}

	
	public String salvarCartao() {

		try {

			cartao.setUsuario(getUsuarioLogadoAsCustomer());
			if (getUsuarioLogadoAsCustomer().getCartoes() != null) {
				getUsuarioLogadoAsCustomer().getCartoes().add(cartao);
			} else {
				getUsuarioLogadoAsCustomer().setCartoes(Arrays.asList(cartao));
			}

			dao.update(getUsuarioLogadoAsCustomer());
			dao.save(cartao);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartão salvo", "Cartão salvo com sucesso"));
			return getUsuarioLogadoAsCustomer().loadDashboard();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public boolean usuarioPossuiAlgumCartao() {
		return !(getUsuarioLogadoAsCustomer().getCartoes().isEmpty());
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String loadNewCardPage() {
		return "new_payment_method?faces-redirect=true";
	}

	public void removerItemDoCarrinho(Item item) {
		try {
			dao.removerItemDoCarrinho(getUsuarioLogadoAsCustomer(), item);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Removido",
					item.getTitulo() + " removido com sucesso"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void removerCartao(Cartao cartao) {

		try {
			dao.removerCartao(getUsuarioLogadoAsCustomer(), cartao);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartão Removido", "Cartão removido com sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "O cartão não pode ser removido", e.getMessage()));
		}

	}

	public void adicionarItemAoCarrinho(Item item) {
		if (getUsuarioLogadoAsCustomer().getCarrinho() != null) {
			if (!(getUsuarioLogadoAsCustomer().getCarrinho().getItens().contains(item))) {
				try {
					dao.adicionarItemAoCarrinho(getUsuarioLogadoAsCustomer(), item);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Item Adicionado", item.getTitulo() + " adicionado ao carrinho."));
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Item Duplicado", "O item já está no seu carrinho"));
			}

		}else {
			try {
				Carrinho c = new Carrinho();
				Cliente cliente = getUsuarioLogadoAsCustomer();
				c.setCliente(cliente);
				c.setItens(Arrays.asList(item));
				cliente.setCarrinho(c);
				dao.save(c);
				dao.update(cliente);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Item Adicionado", item.getTitulo() + " adicionado ao carrinho."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
