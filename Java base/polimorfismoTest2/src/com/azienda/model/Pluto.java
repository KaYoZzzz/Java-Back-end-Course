package com.azienda.model;

public class Pluto extends Pippo{
	private String nomePluto;

	
	public Pluto(String nomePippoString, String nomePlutoString) {
		super(nomePippoString);
		this.nomePluto = nomePlutoString;
		System.out.println("Costruttore Pluto");
	}

	public String getNomePluto() {
		return nomePluto;
	}

	public void setNomePluto(String nomePluto) {
		this.nomePluto = nomePluto;
	}
	
	
}
