package com.azienda.model;

public class Bambino extends Persona {

	private static int contatoreBambino;

	public Bambino(String nome, String cognome, float altezza) {
		super(nome, cognome, altezza);
		contatoreBambino++;
	}

	public static int getContatoreBambino() {
		return contatoreBambino;
	}

	@Override
	public String info() {
		return "Nome Bambino:" + this.nome + "\nCognome bambino:" + this.cognome + "\nAltezza bambino:" + this.altezza;
	}

}
