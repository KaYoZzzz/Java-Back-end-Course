package com.azienda.model;

public class Indirizzo {
	private String comune, stradaOpiazza;
	private Integer civico;

	public Indirizzo() {
		super();
	}

	public Indirizzo(String comune, String stradaOpiazza, Integer civico) {
		super();
		this.comune = comune;
		this.stradaOpiazza = stradaOpiazza;
		this.civico = civico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getStradaOpiazza() {
		return stradaOpiazza;
	}

	public void setStradaOpiazza(String stradaOpiazza) {
		this.stradaOpiazza = stradaOpiazza;
	}

	public Integer getCivico() {
		return civico;
	}

	public void setCivico(Integer civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return "Indirizzo [comune=" + comune + ", stradaOpiazza=" + stradaOpiazza + ", civico=" + civico + "]";
	}

}
