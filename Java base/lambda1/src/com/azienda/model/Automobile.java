package com.azienda.model;

public class Automobile {
	private String marca, modello, dataImmatricolazione;
	private int cilindrata;

	public Automobile(String marca, String modello, String dataImmatricolazione, int cilindrata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.dataImmatricolazione = dataImmatricolazione;
		this.cilindrata = cilindrata;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(String dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Automobile [marca=" + marca + ", modello=" + modello + ", dataImmatricolazione=" + dataImmatricolazione
				+ ", cilindrata=" + cilindrata + "]";
	}

}
