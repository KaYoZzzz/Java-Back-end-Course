package com.azienda.model;

public class DispositivoMultimediale {
	private String marca, modello;
	float prezzo;

	public DispositivoMultimediale(String marca, String modello, float prezzo) {
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
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

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}
