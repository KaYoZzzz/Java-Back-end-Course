package com.azienda.springIOC.esempio1.model;

public class Macchina {
	private Integer id;
	private String marca, modello;

	public Macchina() {
		super();
	}

	public Macchina(Integer id, String marca, String modello) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Macchina [id=" + id + ", marca=" + marca + ", modello=" + modello + "]";
	}

}
