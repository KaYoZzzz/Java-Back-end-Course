package com.azienda.model;

public class Padre extends Nonno{
	private String nomePadre;

	
	public Padre() {
		super();
		System.out.println("Costruttore padre");
	}

	public String getNomePadre() {
		return nomePadre;
	}

	public void setNomePadre(String nomePadre) {
		this.nomePadre = nomePadre;
	}
	
	
}
