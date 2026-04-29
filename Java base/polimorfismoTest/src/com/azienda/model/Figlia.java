package com.azienda.model;

public class Figlia extends Padre{
	private String nomeFiglia;

	public Figlia() {
		super();
		System.out.println("Costruttore figlia");
	}

	public String getNomeFiglia() {
		return nomeFiglia;
	}

	public void setNomeFiglia(String nomeFiglia) {
		this.nomeFiglia = nomeFiglia;
	}
	
	
}
