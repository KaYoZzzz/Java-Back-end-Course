package com.azienda.model;

public class Pippo {
	private String nomePippoString;

	
	public Pippo(String nomePippoString) {
		this.nomePippoString = nomePippoString;
		System.out.println("Costruttore Pippo");
	}

	public String getNomePippoString() {
		return nomePippoString;
	}

	public void setNomePippoString(String nomePippoString) {
		this.nomePippoString = nomePippoString;
	}
	
	
}
