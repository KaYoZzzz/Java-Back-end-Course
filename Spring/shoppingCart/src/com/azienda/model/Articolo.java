package com.azienda.model;

public class Articolo {
	private String nome;
	private Float prezzo;

	public Articolo(String nome, Float prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public Articolo() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Articolo [nome=" + nome + ", prezzo=" + prezzo + "]";
	}

}
