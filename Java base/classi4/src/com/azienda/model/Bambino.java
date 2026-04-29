package com.azienda.model;

public class Bambino {
	private String nome, cognome;
	private float altezza;
	private static int contatore;
	
	
	
	public Bambino(String nome, String cognome, float altezza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.altezza = altezza;
		contatore++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public float getAltezza() {
		return altezza;
	}
	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}
	

	public static int getContatore() {
		return contatore;
	}
	
	public void cresce(float altezza) {
		this.altezza+=altezza;
	}
	
	public String infoBambino() {
		return "Nome:" + nome + "\nCognome:" + this.cognome + "\nAltezza:" + this.altezza;
	}
}
