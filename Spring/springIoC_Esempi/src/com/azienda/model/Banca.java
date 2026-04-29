package com.azienda.model;

public class Banca {
	private String nome;
	private Indirizzo indirizzo;

	public Banca() {
		super();
	}

	public Banca(String nome, Indirizzo indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
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

	@Override
	public String toString() {
		return "Banca [nome=" + nome + ", indirizzo=" + indirizzo + "]";
	}

}
