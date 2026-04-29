package com.azienda.EsercizioRest1.model;

import java.util.Objects;

public class Localita {
	private Integer id;
	private String nome;
	private Float temperatura;

	public Localita() {
		super();
	}

	public Localita(Integer id, String nome, Float temperatura) {
		super();
		this.id = id;
		this.nome = nome;
		this.temperatura = temperatura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Localita [id=" + id + ", nome=" + nome + ", temperatura=" + temperatura + "]";
	}

	// località uguale anche solo se id è uguale
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		Localita other = (Localita) obj;
		return Objects.equals(id, other.id);
	}

}
