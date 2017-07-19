package com.headline.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.headline.model.itens.Fisico;
import com.headline.model.itens.Item;

import javassist.expr.Instanceof;

@ManagedBean
@ViewScoped
public class ItemSelecionado {
	
	private Item item;
	
	public void adicionarAoCarrinho(){
		if(item.getClass().isInstance(Fisico.class)){
			((Fisico) item).setQuantidadeEmEstoque(((Fisico) item).getQuantidadeEmEstoque()-1);
			//dao.update(item)
		}
		DashboardLoader.getCarrinho().add(item);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public String load(){
		return"select_item?faces-redirect=true";
	}
	
	
	

}
