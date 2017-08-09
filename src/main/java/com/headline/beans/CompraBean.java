package com.headline.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.headline.model.Carrinho;
import com.headline.model.Cartao;
import com.headline.model.Compra;
import com.headline.model.Entrega;
import com.headline.model.Estante;
import com.headline.model.Status;
import com.headline.model.itens.Fisico;
import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;
import com.headline.persistence.ClienteDAO;

@Named
@ViewScoped
public class CompraBean extends UsuarioOperations implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private ClienteDAO dao;

	private Cartao cartao;
	
	@PostConstruct
	public void initialize() {
		dao = new ClienteDAO();
	}

	public void fecharCompra(Carrinho carrinho) {
		try {
			ArrayList<Item> itens = new ArrayList<Item>();
			ArrayList<Item> estante = new ArrayList<Item>();

			Cliente cliente = getUsuarioLogadoAsCustomer();

			for (Item i : carrinho.getItens()) {

				if (i instanceof Fisico) {
					((Fisico) i).setQuantidadeEmEstoque(((Fisico) i).getQuantidadeEmEstoque()-1);
					itens.add(i);
					dao.update(i);
				} else {
					estante.add(i);
				}

				if (!itens.isEmpty()) {
					Compra compra = new Compra();
					Entrega entrega = new Entrega();
					compra.setItens(itens);
					compra.setCliente(cliente);
					compra.setData(LocalDate.now());
					compra.setCartao(cartao);
					entrega.setCompra(compra);
					entrega.setStatus(Status.PENDENTE);
					entrega.setPrevisao(LocalDate.now().plusDays(3));
					if (cliente.getCompras() != null) {
						cliente.setCompras(Arrays.asList(compra));
					} else {
						cliente.getCompras().add(compra);
					}
					dao.save(compra);
					dao.save(entrega);
				}

				if (!estante.isEmpty()) {
					if (cliente.getEstante()==null) {
						Estante shelf = new Estante();
						shelf.setCliente(cliente);
						shelf.setLivros(estante);
						cliente.setEstante(shelf);
					} else {
						cliente.getEstante().getLivros().addAll(estante);
					}
				}

			}
			cliente.setCarrinho(new Carrinho());
			dao.update(cliente);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra salva", "Sua compra foi salva com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao processar compra", e.getMessage()));
			e.printStackTrace();
		}

	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
