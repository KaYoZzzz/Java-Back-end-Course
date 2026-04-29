package com.azienda.model;

public class Fabbrica {
	private String nome;
	private Indirizzo indirizzo;
	private int numeroAutoProdotte;
	
	public Fabbrica(String nome, Indirizzo indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroAutoProdotte = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getNumeroAutoProdotte() {
		return numeroAutoProdotte;
	}
	
	public void produciAuto() {
		this.numeroAutoProdotte +=1;
	}
	
	public String infoFabbrica() {
		return "Nome: " + this.nome +
				"\n"+this.indirizzo.infoIndirizzo() +
				"\nAuto prodotte: " +this.getNumeroAutoProdotte();
	}
}
