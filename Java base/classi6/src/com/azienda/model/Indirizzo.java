package com.azienda.model;

public class Indirizzo {
	private String nazione, citta, strada;
	int cap;
	
	public Indirizzo(String nazione, String citta, String strada, int cap) {
		super();
		this.nazione = nazione;
		this.citta = citta;
		this.strada = strada;
		this.cap = cap;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getStrada() {
		return strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}
	
	public String infoIndirizzo() {
		return "Nazione: " + this.nazione 
				+ "\nCittà: " + this.citta 
				+ "\nStrada: " + this.strada 
				+ "\nCap: " + this.cap;
	}
	
	
}
