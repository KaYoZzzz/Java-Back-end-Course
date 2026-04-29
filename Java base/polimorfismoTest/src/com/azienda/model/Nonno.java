package com.azienda.model;

public class Nonno {
	private String nomeNonnoString;

	
	public Nonno() {
		super();
		System.out.println("Costruttore nonno");
	}

	public String getNomeNonnoString() {
		return nomeNonnoString;
	}

	public void setNomeNonnoString(String nomeNonnoString) {
		this.nomeNonnoString = nomeNonnoString;
	}
	
	
}
