package com.headline.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.headline.model.Cartao;
import com.headline.model.Entrega;
import com.headline.model.itens.Item;
import com.headline.model.usuarios.Cliente;

public class ClienteDAO extends GenericDAO{

	public void removerCartao(Cliente cliente, Cartao cartao) throws Exception{
		
			cliente.getCartoes().remove(cartao);
			cartao.setUsuario(null);
			this.update(cliente);
	}
	
	
	public void adicionarItemAoCarrinho(Cliente cliente, Item item) throws Exception {
		cliente.getCarrinho().getItens().add(item);
		this.update(cliente);
		
	}
	
	public void removerItemDoCarrinho(Cliente cliente, Item item) throws Exception {
		cliente.getCarrinho().getItens().remove(item);
		this.update(cliente);
		
	}
	
	public List<Entrega> getEntregas(Cliente cliente){
		
		EntityManager em = getEntityManager();
		List<Entrega> entregas = null;
		
		try {
			TypedQuery<Entrega> entregasQuery = em.createQuery("SELECT e FROM Entrega e WHERE e.compra.cliente.cpf = :cpf",Entrega.class);
			entregasQuery.setParameter("cpf", cliente.getCpf());
			entregas = entregasQuery.getResultList();
			return entregas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
