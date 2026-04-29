package com.azienda.esempio3.model;

public class Persona {
	private String nome, cognomeString;

	public Persona(String nome, String cognomeString) {
		super();
		this.nome = nome;
		this.cognomeString = cognomeString;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognomeString() {
		return cognomeString;
	}

	public void setCognomeString(String cognomeString) {
		this.cognomeString = cognomeString;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognomeString=" + cognomeString + "]";
	}

}
