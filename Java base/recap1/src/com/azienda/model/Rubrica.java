package com.azienda.model;

import java.util.ArrayList;

public class Rubrica {
	String nome;
	int anno;
	ArrayList<Contatto> contatti;

	public Rubrica(String nome, int anno, ArrayList<Contatto> contatti) {
		super();
		this.nome = nome;
		this.anno = anno;
		this.contatti = contatti;
	}

	public Rubrica(String nome, int anno) {
		super();
		this.nome = nome;
		this.anno = anno;
		this.contatti = new ArrayList<Contatto>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public ArrayList<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(ArrayList<Contatto> contatti) {
		this.contatti = contatti;
	}

	/**
	 * aggiunge il contatto alla rubrica
	 * 
	 * @param c
	 */
	public void addContatto(Contatto c) {
		this.contatti.add(c);
	}

	/**
	 * Controlla se il contatto è presente all'interno della rubrica
	 * 
	 * @param c
	 * @return
	 */
	public boolean containsContatto(Contatto c) {
		return this.contatti.contains(c);
	}

	/**
	 * Stampa tutti i contatti in questa rubrica
	 */

}
