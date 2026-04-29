package com.azienda.jdbcEsercizio.model;

import java.util.Objects;

public class Automobile {
	private Integer id;
	private String marca, modello, targa, colore;
	private Float cilindrata;

	public Automobile(Integer id, String marca, String modello, String targa, String colore, Float cilindrata) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.colore = colore;
		this.cilindrata = cilindrata;
	}

	public Automobile() {
		super();
	}

	public Automobile(String marca, String modello, String targa, String colore, Float cilindrata) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.colore = colore;
		this.cilindrata = cilindrata;
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

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Float getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Float cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + this.marca + ", modello=" + modello + ", targa=" + targa
				+ ", colore=" + colore + ", cilindrata=" + cilindrata + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cilindrata, colore, marca, modello, targa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Automobile other = (Automobile) obj;
		return Objects.equals(cilindrata, other.cilindrata) && Objects.equals(colore, other.colore)
				&& Objects.equals(marca, other.marca) && Objects.equals(modello, other.modello)
				&& Objects.equals(targa, other.targa);
	}

}
