package com.azienda.model;

public class Automobile {
	private String modello, marca, targa;
	private int cilindrata;
	private Fabbrica fabbrica;
	
	public Automobile(String modello, String marca, String targa, int cilindrata, Fabbrica fabbrica) {
		super();
		this.modello = modello;
		this.marca = marca;
		this.targa = targa;
		this.cilindrata = cilindrata;
		this.fabbrica = fabbrica;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public Fabbrica getFabbrica() {
		return fabbrica;
	}
	public void setFabbrica(Fabbrica fabbrica) {
		this.fabbrica = fabbrica;
	}
	
	public String infoAutomobile() {
		return "Modello: " + this.modello +
				"\nMarca: " + this.marca +
				"\nTarga: " + this.targa +
				"\nCilindrata: " + this.cilindrata +
				"\n" +this.fabbrica.infoFabbrica();
	}
	
}
