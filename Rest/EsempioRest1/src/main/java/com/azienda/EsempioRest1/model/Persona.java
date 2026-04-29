package com.azienda.EsempioRest1.model;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Persona {
	@Positive(message = "Errore: ID negativo")
	public Integer id;
	@NotNull(message = "Errore: Campo nome obbligatorio")
	@NotBlank(message = "Errore: nome vuoto")
	private String nome;
	@NotNull(message = "Errore: Campo cognome obbligatorio")
	@NotBlank(message = "Errore: cognome vuoto")
	private String cognome;

	public Persona() {
		super();
	}

	public Persona(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

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
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}

}
