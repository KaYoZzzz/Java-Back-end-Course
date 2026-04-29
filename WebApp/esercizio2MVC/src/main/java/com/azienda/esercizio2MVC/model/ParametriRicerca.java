package com.azienda.esercizio2MVC.model;

public class ParametriRicerca {
	private String citta, via;

	public ParametriRicerca() {
		super();
	}

	public ParametriRicerca(String citta, String via) {
		super();
		this.citta = citta;
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	@Override
	public String toString() {
		return "ParametriRicerca [citta=" + citta + ", via=" + via + ", getCitta()=" + getCitta() + ", getVia()="
				+ getVia() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
