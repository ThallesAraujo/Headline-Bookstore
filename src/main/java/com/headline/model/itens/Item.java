package com.headline.model.itens;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.headline.model.Editora;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="Tipo")
public class Item implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String titulo;
	private String autor;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private BigDecimal preco;
	
	@ManyToOne(optional = false)
	private Editora produtor;
	
	@Lob
	private byte[] capa;
	
	@Lob
	private String resumo;
	
	public Item(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Editora getProdutor() {
		return produtor;
	}

	public void setProdutor(Editora produtor) {
		this.produtor = produtor;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public boolean isEmFalta() {
		return false;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + Arrays.hashCode(capa);
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((produtor == null) ? 0 : produtor.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (!Arrays.equals(capa, other.capa))
			return false;
		if (categoria != other.categoria)
			return false;
		if (genero != other.genero)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (produtor == null) {
			if (other.produtor != null)
				return false;
		} else if (!produtor.equals(other.produtor))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	
	
	
	
	

}
