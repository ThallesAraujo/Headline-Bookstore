package com.headline.model.itens;


public enum Genero{
	
	AUTOAJUDA("Autoajuda"),
	BIOGRAFIA("Biografia"),
	COMEDIA("Comédia"),
	CIENTIFICO("Científico"),
	CULINARIA("Culinária"),
	DIY("Do It Yourself (DIY)"),
	EDUCACIONAL("Educacional"),
	FICCAO("Ficcção"),
	HQ_MANGA("HQ's e Mangás"),
	IDIOMAS("Idiomas"),
	INFANTIL("Infantil"),
	POESIA("Poesia"),
	POLITICA("Política"),
	RELIGIAO("Religião"),
	ROMANCE("Romance"),
	SAUDE("Saúde"),
	SUSPENSE("Suspense e Terror"),
	TECNOLOGIA("Tecnologia"),
	TURISMO("Turismo"),
	OUTROS("Outros");
	
	private final String nome;
	
	
	private Genero(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	
	
}
