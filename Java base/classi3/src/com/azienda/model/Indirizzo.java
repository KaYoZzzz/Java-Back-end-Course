package com.azienda.model;

public class Indirizzo {
	private String citta, stradaPiazza;
	private int numeroCivico;
	
	
	public Indirizzo(String citta, String stradaPiazza, int numeroCivico) {
		super();
		this.citta = citta;
		this.stradaPiazza = stradaPiazza;
		this.numeroCivico = numeroCivico;
	}
	
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getStradaPiazza() {
		return stradaPiazza;
	}
	public void setStradaPiazza(String stradaPiazza) {
		this.stradaPiazza = stradaPiazza;
	}
	public int getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	
	public String descrizione () {
		return "Città:" + this.citta +
				"\nStrada/Piazza:" + this.stradaPiazza +
				"\nNumeroCivico:" + this.numeroCivico;
	}
}
